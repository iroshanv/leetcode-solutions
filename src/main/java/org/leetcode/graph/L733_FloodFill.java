package org.leetcode.graph;

import org.junit.jupiter.api.Test;

/**
 * #Array #DFS #BFS #Matrix
 *
 *
 * https://leetcode.com/problems/flood-fill/


 * Input: image =
 *   [ [1,1,1],
 *     [1,1,0],
 *     [1,0,1] ]
 *
 * sr = 1, sc = 1, color = 2
 * Output:
 *   [ [2,2,2],
 *     [2,2,0],
 *     [2,0,1] ]
 *
 * all one's are replaced with 2
 *
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
 * all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 *
 *
 * https://www.youtube.com/watch?v=aehEcTEPtCs
 */
public class L733_FloodFill {

    @Test
    public void floodFillTest() {
        int[][] image = { {1, 1, 1},
                          {1, 1, 0},
                          {1, 0, 1} };
        floodFill(image, 1, 1, 2);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    // approach: DFS
    public static void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (image[sr][sc] == oldColor) {

            image[sr][sc] = newColor;

            if(sr >= 1) fill(image, sr - 1, sc, oldColor, newColor);
            if(sc >= 1) fill(image, sr, sc - 1, oldColor, newColor);

            if(sr + 1 < image.length) fill(image, sr + 1, sc, oldColor, newColor);        // image.length gives row length
            if(sc + 1 < image[0].length) fill(image, sr, sc + 1, oldColor, newColor);     // image[0].length gives col length
        }
    }
}
