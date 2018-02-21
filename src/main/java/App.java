import com.prateek.army.Repository.OwnersRepository;
import com.prateek.army.model.Owners;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class App {

   /* private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.
            createEntityManagerFactory("ComplaintPortalPU");*/

    public static void main(String[] args){

        /*EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
*/
        //Testing CountAll
        OwnersRepository ownersRepository = new OwnersRepository();
        System.out.println(ownersRepository.countAll());
    }
}
