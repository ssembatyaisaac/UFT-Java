package UFT.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
        private static final EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("UFT_Political_PartyPU");

        public static EntityManagerFactory getEmFactory() {
                return emf;
        }
}