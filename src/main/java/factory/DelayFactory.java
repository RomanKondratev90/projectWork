package factory;

public class DelayFactory {
    private static long actionDelay = 500; //Значение задержки по умолчанию

    //Метод для установки задержки
    public static void setActionDelay(long delay) {
        actionDelay = delay;
    }

    //Метод для получения текущей задержки
    public static long getActionDelay() {
        return actionDelay;
    }
}