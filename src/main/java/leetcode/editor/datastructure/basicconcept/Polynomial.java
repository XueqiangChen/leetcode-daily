package leetcode.editor.datastructure.basicconcept;

/**
 * 计算给定多项式在给定点x处的值
 */
public class Polynomial {
    /**
     * 原多项式：f(x)=a(0)+a(1)*x+...+a(n-1)*x^(n-1)+a(n)*x^n
     * 提取公因子后的多项式：f(x)=a(0)+x(a(1)+x(..(a(n-1)+x(a(n)))...))
     */
    public double func(int n, double[] a, double x) {
        int i;
        double p = a[n];
        for (i=n; i>0; i--) {
            p = a[i-1] + x*p;
        }

        return p;
    }

    public static void main(String[] args) {
        Polynomial polynomial = new Polynomial();
        System.out.println(polynomial.func(1, new double[]{1,2}, 3));
    }
}
