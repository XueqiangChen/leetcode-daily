package leetcode.editor.datastructure.tree;

public class SetType {
    // 集合程序
    /*#define MAXN 1000                  *//* 集合最大元素个数 *//*
    typedef int ElementType;           *//* 默认元素可以用非负整数表示 *//*
    typedef int SetName;               *//* 默认用根结点的下标作为集合名称 *//*
    typedef ElementType SetType[MAXN]; *//* 假设集合元素下标从0开始 *//*

    void Union( SetType S, SetName Root1, SetName Root2 )
    { *//* 这里默认Root1和Root2是不同集合的根结点 *//*
        *//* 保证小集合并入大集合 *//*
        if ( S[Root2] < S[Root1] ) { *//* 如果集合2比较大 *//*
            S[Root2] += S[Root1];     *//* 集合1并入集合2  *//*
            S[Root1] = Root2;
        }
        else {                         *//* 如果集合1比较大 *//*
            S[Root1] += S[Root2];     *//* 集合2并入集合1  *//*
            S[Root2] = Root1;
        }
    }

    SetName Find( SetType S, ElementType X )
    { *//* 默认集合元素全部初始化为-1 *//*
        if ( S[X] < 0 ) *//* 找到集合的根 *//*
            return X;
        else
            return S[X] = Find( S, S[X] ); *//* 路径压缩 *//*
    }*/


    private int data;
    private int parent;

    public SetType(int data, int parent) {
        this.data = data;
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int find(int x) {
        // 在数组
        return 0;
    }

    public int hashString(String key, int tableSize) {
        int h = 0; //散列函数值，初始化为0
        char[] keyArrays = key.toCharArray();
        for (int i = 0; i <= keyArrays.length; i++) {
            if (keyArrays[i] != '\0') {
                h = (h << 5) + keyArrays[i];
            }
        }
        return h % tableSize;
    }
}
