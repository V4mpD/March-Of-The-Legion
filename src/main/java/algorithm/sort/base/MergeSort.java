package algorithm.sort.base;

import algorithm.sort.strategy.SortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T> implements SortingStrategy<T> {
    @Override
    public List<T> sort(List<T> list) {
        List<T> aux = new ArrayList<>(list);

        int sAux = aux.size();

        for (int sSub = 1; sSub < sAux; sSub *= 2) {
            for (int left = 0; left < sAux; left += 2 * sSub) {
                int mid = Math.min(left + sSub, sAux);
                int right = Math.min(left + 2 * sSub, sAux);

                if (mid >= right) break;

                List<T> subLeft = new ArrayList<>(aux.subList(left, mid));
                List<T> subRight = new ArrayList<>(aux.subList(mid, right));

                List<T> merged = new ArrayList<>(right - left);
                int l = 0, r = 0;

                while (l < subLeft.size() && r < subRight.size()) {
                    if (subLeft.get(l).hashCode() <= subRight.get(r).hashCode()) {
                        merged.add(subLeft.get(l++));
                    } else {
                        merged.add(subRight.get(r++));
                    }
                }

                while (l < subLeft.size()){
                    merged.add(subLeft.get(l++));
                }
                while (r < subRight.size()){
                    merged.add(subRight.get(r++));
                }

                for (int i = 0; i < merged.size(); i++) {
                    aux.set(left + i, merged.get(i));
                }
            }
        }

        return aux;
    }
}
