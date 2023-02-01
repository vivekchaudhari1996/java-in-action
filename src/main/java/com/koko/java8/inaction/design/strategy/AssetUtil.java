package com.koko.java8.inaction.design.strategy;

import java.util.Arrays;
import java.util.List;

import static com.koko.java8.inaction.design.strategy.Asset.*;

public class AssetUtil {

	public static void main(String[] args) {
		final List<Asset> assets = Arrays.asList(new Asset(AssetType.BOND, 1000), new Asset(AssetType.BOND, 2000),
				new Asset(AssetType.STOCK, 3000), new Asset(AssetType.STOCK, 4000));

		System.out.println("Total of all assets: " + totalAssetValues(assets));
		System.out.println("Total of bonds: " + totalBondValues(assets));
		System.out.println("Total of stocks: " + totalStockValues(assets));
	}

	public static int totalAssetValues(final List<Asset> assets) {
		return assets.stream().mapToInt(Asset::getValue).sum();
	}

	public static int totalBondValues(final List<Asset> assets) {
		return assets.stream().mapToInt(asset -> asset.getType() == AssetType.BOND ? asset.getValue() : 0).sum();
	}

	public static int totalStockValues(final List<Asset> assets) {
		return assets.stream().mapToInt(asset -> asset.getType() == AssetType.STOCK ? asset.getValue() : 0).sum();
	}
}
