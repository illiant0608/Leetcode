public class FriendCirles_547 {
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0;i < M.length;i++) {
            for (int j = 0;j < M[i].length;j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }

        return uf.setNum;
    }

    class UF {

        int[] id;
        int setNum; //连通分量个数

        public UF (int n) {
            id = new int[n];
            for (int i = 0;i < n;i++) {
                id[i] = i;
            }

            setNum = n;
        }

        boolean union(int a, int b) {
            int root1 = find(a);
            int root2 = find(b);
            if (root1 == root2) return false;
            else {
                id[root2] = root1;
                --setNum;
                return true;
            }
        }

        int find(int k ) {
            while (k != id[k]) {
                id[k] = id[id[k]]; //压缩路径 把子树连到它的祖父节点
                k = id[k];
            }

            return k;
        }
    }
}
