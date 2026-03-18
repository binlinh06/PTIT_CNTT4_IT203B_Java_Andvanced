package session08.hw05;

class ACSetCommand implements Command {
    private AirConditioner ac;

    public ACSetCommand(AirConditioner ac) {
        this.ac = ac;
    }

    public void execute() {
        System.out.println("SleepMode: Điều hòa set 28°C");
        ac.setTemperature(28);
    }
}