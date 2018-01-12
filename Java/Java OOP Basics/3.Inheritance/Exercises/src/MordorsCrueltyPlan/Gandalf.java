package MordorsCrueltyPlan;

public class Gandalf {
    private int happiness;

    public Gandalf() {
        this.happiness = 0;
    }

    public void eat(String food) {
        switch (food) {
            case "cram":
                this.happiness += 2;
                break;
            case "lembas":
                this.happiness += 3;
                break;
            case "melon":
                this.happiness += 1;
                break;
            case "apple":
                this.happiness += 1;
                break;
            case "honeycake":
                this.happiness += 5;
                break;
            case "mushrooms":
                this.happiness -= 10;
                break;
            default: this.happiness -= 1;
                break;
        }
    }


    private String getMood() {
        int happines = this.getHappiness();
        if (happiness < -5) {
            return "Angry";
        } else if (happiness < 0) {
            return "Sad";
        } else if (happiness < 15) {
            return "Happy";
        }
        return "JavaScript";
    }

    private int getHappiness() {
        return happiness;
    }

    @Override
    public String toString() {
        return this.getHappiness() + System.lineSeparator() + this.getMood();
    }
}
