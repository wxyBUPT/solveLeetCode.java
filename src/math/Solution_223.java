package math;

/**
 * Created by xiyuanbupt on 9/13/16.
 Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

 Rectangle Area
 Assume that the total area is never beyond the maximum possible value of int.
 */
public class Solution_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A,E),right = Math.max(Math.min(C,G),left);
        int bottom = Math.max(B,F),top = Math.max(bottom,Math.min(D,H));
        return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
    }
}
