package com.koko.dataStructures.Misc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PossibleRecipesFromGivenSupplies {

    // Q:
    /*
    You have information about n different recipes.
    You are given a string array recipes and a 2D string array ingredients.
    The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients
    from ingredients[i].
    Ingredients to a recipe may need to be created from other recipes, i.e.,
    ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have,
and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.
     */



    // Example:
    /*
    Input: recipes = ["bread","sandwich"],
    ingredients = [["yeast","flour"],["bread","meat"]],
    supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
     */



    // Solution1:
    // Using topo sort

    // Idea:
    // For each recipe, count its non-available ingredients as in degree;
    // Store (non-available ingredient, dependent recipes) as HashMap;
    //Store all 0-in-degree recipes into a list as the starting points of topological sort;
    //Use topogical sort to decrease the in degree of recipes,
    // whenever the in-degree reaches 0, add it to return list.

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        // Put all supplies into HashSet.
        Set<String> available = Stream.of(supplies).collect(Collectors.toCollection(HashSet::new));
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            int nonAvailable = 0;
            for (String ing : ingredients.get(i)) {
                if (!available.contains(ing)) {
                    ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
                    ++nonAvailable;
                }
            }
            if (nonAvailable == 0) {
                ans.add(recipes[i]);
            }else {
                inDegree.put(recipes[i], nonAvailable);
            }
        }
        // Toplogical Sort.
        for (int i = 0; i < ans.size(); ++i) {
            String recipe = ans.get(i);
            if (ingredientToRecipes.containsKey(recipe)) {
                for (String rcp : ingredientToRecipes.remove(recipe)) {
                    if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        ans.add(rcp);
                    }
                }
            }
        }
        return ans;
    }




    // Sol2:
    // Using topo sort and DFS

    private static final int NOT_VISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public List<String> findAllRecipes2(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> status = new HashMap<>();
        Map<String, List<String>> prereqs = new HashMap<>();

        for (int i = 0; i < recipes.length; ++ i) {
            status.put(recipes[i], NOT_VISITED);
            prereqs.put(recipes[i], ingredients.get(i));
        }

        for (String s: supplies) {
            status.put(s, VISITED);
        }

        List<String> output = new ArrayList<>();
        for (String s: recipes) {
            dfs (s, prereqs, status, output);
        }

        return output;
    }

    public boolean dfs(String s, Map<String, List<String>> prereqs, Map<String, Integer> status, List<String> output) {
        if (!status.containsKey(s)) {
            return false;
        }

        if (status.get(s) == VISITING) {
            return false;
        }

        if (status.get(s) == VISITED) {
            return true;
        }

        status.put(s, VISITING);
        for (String p: prereqs.get(s)) {
            if (!dfs(p, prereqs, status, output)) {
                return false;
            }
        }
        status.put(s, VISITED);
        output.add(s);

        return true;
    }
}
