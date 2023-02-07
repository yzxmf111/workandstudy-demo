package cn.xiaotian.Factory_parttern.simplefactory;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-06 17:34
 */
public abstract class Computer {

    private String name;

    private String ConfigConfiguration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfigConfiguration() {
        return ConfigConfiguration;
    }

    public void setConfigConfiguration(String configConfiguration) {
        ConfigConfiguration = configConfiguration;
    }

    public abstract void playGamesByComputer(Computer computer);
}
