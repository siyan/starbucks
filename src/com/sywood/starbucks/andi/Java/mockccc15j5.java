package com.sywood.starbucks.andi.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Andi Gu
 */
public class mockccc15j5 {
    private static final Comparator<int[]> h_compare = (o1, o2) -> {
        int result = Integer.compare(o1[0], o2[0]);
        if (result == 0) {
            result = Integer.compare(o1[1], o2[1]);
        }
        return result;
    };
    private static final Comparator<int[]> v_compare = (o1, o2) -> {
        int result = Integer.compare(o1[1], o2[1]);
        if (result == 0) {
            result = Integer.compare(o1[0], o2[0]);
        }
        return result;
    };
    private static int n_buildings;
    private static List<int[]> horizontal;
    private static List<int[]> vertical;

    private static int bisect(int[] x, boolean isHorizontal) {
        Comparator<int[]> comparator = isHorizontal ? h_compare : v_compare;
        List<int[]> list = isHorizontal ? horizontal : vertical;
        int low = 0, high = n_buildings;
        while (low < high) {
            int mid = (low + high) / 2;
            if (comparator.compare(x, list.get(mid)) < 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int bisect_end(int[] x, boolean isHorizontal) {
        Comparator<int[]> comparator = isHorizontal ? h_compare : v_compare;
        List<int[]> list = isHorizontal ? horizontal : vertical;
        int low = 0, high = n_buildings;
        while (low < high) {
            int mid = (low + high) / 2;
            if (comparator.compare(x, list.get(mid)) <= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] tokens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n_buildings = Integer.parseInt(reader.readLine().split(" ")[0]);
        horizontal = new ArrayList<>();
        vertical = new ArrayList<>();
        for (int i = 0; i < n_buildings; i++) {
            tokens = reader.readLine().split(" ");
            int[] coordinate = new int[]{Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])};
            horizontal.add(coordinate);
            vertical.add(coordinate);
        }
        horizontal.sort(h_compare);
        vertical.sort(v_compare);

        int n_turnings = Integer.parseInt(reader.readLine().split(" ")[0]);
        int[][] turnings = new int[n_turnings][2];
        for (int i = 0; i < n_turnings; i++) {
            tokens = reader.readLine().split(" ");
            turnings[i] = new int[]{Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])};
        }


        long result = 0;
        for (int i = 0; i < n_turnings - 1; i++) {
            if (turnings[i][0] == turnings[i + 1][0]) {
                if (turnings[i][1] > turnings[i + 1][1]) {
                    result += bisect(turnings[i], true) - bisect_end(turnings[i + 1], true);
                } else {
                    result += bisect(turnings[i + 1], true) - bisect_end(turnings[i], true);
                }
            } else {
                if (turnings[i][0] > turnings[i + 1][0]) {
                    result += bisect(turnings[i], false) - bisect_end(turnings[i + 1], false);
                } else {
                    result += bisect(turnings[i + 1], false) - bisect_end(turnings[i], false);
                }
            }
        }
        System.out.println(result);
    }
}
