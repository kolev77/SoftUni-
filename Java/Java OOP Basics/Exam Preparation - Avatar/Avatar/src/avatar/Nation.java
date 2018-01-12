package avatar;

import avatar.benders.Bender;
import avatar.monuments.Monument;

import java.util.Collections;
import java.util.List;

 class Nation {
    private List<Bender> benders;
    private List<Monument> monuments;

     Nation(List<Bender> benders, List<Monument> monuments) {
        this.benders = benders;
        this.monuments = monuments;
    }

    double calculateNationPower(){
        Double total = 0.0;

        for (Bender bender : benders) {
            total += bender.getTotalPower();
        }

        Long sum = 0l;

        for (Monument monument : monuments) {
            sum += monument.getPower();
        }

        total += (total / 100) * sum;

         return total;
    }

     void addBender(Bender bender){
        this.benders.add(bender);
    }

     void addMonument(Monument monument){
        this.monuments.add(monument);
    }

     List<Bender> getBenders() {
        return Collections.unmodifiableList(benders);
    }

     List<Monument> getMonuments() {
        return Collections.unmodifiableList(monuments);
    }

     void clearBenders() {
         this.benders.clear();
     }

     void clearMonuments() {
         this.monuments.clear();
     }
}
