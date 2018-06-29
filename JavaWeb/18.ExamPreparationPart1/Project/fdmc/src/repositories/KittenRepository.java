package repositories;

import entities.Kitten;

import java.util.List;

public class KittenRepository extends BaseRepository {
    public void createKitten(Kitten kitten) {
        this.execute(actionResult -> KittenRepository.this.em.persist(kitten));
    }

    public Kitten[] allKittens() {
        Kitten[] allKittens = (Kitten[]) this.execute(actionResult -> {
            List<Kitten> kittens = this.em.createNativeQuery(
                    "SELECT * FROM kittens AS k", Kitten.class)
                    .getResultList();
            Kitten[] kittensArray = new Kitten[kittens.size()];
            for (int i = 0; i < kittensArray.length; i++) {
                kittensArray[i] = kittens.get(i);
            }

            actionResult.setResult(kittensArray);
        }).getResult();

        return allKittens;
    }
}
