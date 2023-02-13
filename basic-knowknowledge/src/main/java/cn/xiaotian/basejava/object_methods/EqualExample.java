package cn.xiaotian.basejava.object_methods;

import java.util.Objects;

public class EqualExample {
    private int x;
    private int y;
    private int z;
    private String e;
    private String d;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualExample that = (EqualExample) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }


}
