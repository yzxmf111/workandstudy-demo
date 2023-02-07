package cn.xiaotian.singlepattern;

public enum Singleton2 {
    INSTANCE;

    private String objName;


    public String getObjName() {
        return objName;
    }


    public void setObjName(String objName) {
        this.objName = objName;
    }


    public static void main(String[] args) {

        // 单例测试
        Singleton2 firstSingleton = Singleton2.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());
        Singleton2 secondSingleton = Singleton2.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());
        System.out.println(firstSingleton == secondSingleton);

        // 反射获取实例测试
        try {
            Singleton2[] enumConstants = Singleton2.class.getEnumConstants();
            for (Singleton2 enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
