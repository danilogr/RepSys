package presentation;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import vo.ContaVO;
import vo.UserVO;
import business.BusinessFactory;
import business.spec.IConta;
import business.spec.IUsuario;

public class Client {

    public static void main(String[] args) throws Exception {

        BusinessFactory factory = BusinessFactory.getInstance();

        IUsuario user = factory.getUser();
        IConta account = factory.getAccount();
        List userList;
        List accountList;
        UserVO userVO;
        ContaVO accountVO;
        Iterator iterator;

        userVO = new UserVO("admin", "admin");
        user.authenticate(userVO);

        userList = user.getAll();
        iterator = userList.iterator();

        while (iterator.hasNext()) {
            userVO = (UserVO) iterator.next();
            System.out.println(userVO);
        }

        if (userList.size() > 1) {
            // Atualizando o segundo
            userVO = (UserVO) userList.get(1);
            userVO.setName("Atualizado");
            System.out.println("Updating " + userVO);
            user.update(userVO);
            // Removendo o primeiro
            userVO = (UserVO) userList.get(0);
            int id = userVO.getId();
            accountVO = account.getContaByUsuario(id);

            if (accountVO != null) {
                System.out.println("Deleting " + accountVO);
                account.delete(accountVO.getId());
            }

            System.out.println("Deleting " + userVO);
            user.delete(userVO.getId());
        }

        // criando um novo
        userVO = new UserVO("admin"
                + Calendar.getInstance().getTime().getTime(), "admin",
                "Administrador");
        System.out.println("Creating " + userVO);
        user.create(userVO);

        accountVO = new ContaVO("0958-0", new Double(20.6f), userVO);
        System.out.println("Creating " + accountVO);
        account.create(accountVO);

        accountList = account.getAll();
        iterator = accountList.iterator();

        while (iterator.hasNext()) {
            accountVO = (ContaVO) iterator.next();
            System.out.println(accountVO);
        }

        if (accountList.size() > 1) {

            ContaVO vo1 = (ContaVO) accountList.get(0);
            ContaVO vo2 = (ContaVO) accountList.get(1);

            vo1.setSaldo(vo1.getSaldo() - 100);
            vo2.setSaldo(vo2.getSaldo() + 100);
            account.update(vo1);
            account.update(vo2);
        }
    }
}
