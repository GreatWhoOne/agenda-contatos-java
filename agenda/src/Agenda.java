import dao.DaoContact;
import entities.Contact;

import java.util.List;
import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
        while(true) {
            char option = menu();
            switch (option){
                case 's' :
                    saveContact(); break;
                case 'a' :
                    updateContact(); break;
                case 'e' :
                    deleteContact(); break;
                case 'c' :
                   listById(); break;
                case 'l' :
                    listAll(); break;
                case 'x' :
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    static void saveContact(){
        Scanner sc = new Scanner(System.in);

        System.out.println("informe o nome do contato");
        String name = sc.nextLine();

        System.out.println("informe o email do contato");
        String email = sc.nextLine();

        System.out.println("informe o fone do contato");
        String fone = sc.nextLine();

        Contact ct = new Contact(name, email, fone);

        DaoContact dc = new DaoContact();
        if(dc.saveContact(ct)) {
            System.out.println("Contato salvo com sucesso");
        }
    }

    static void deleteContact(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o código do contato para exclusão: ");
        int idContact = sc.nextInt();

        DaoContact dc = new DaoContact();
        Contact contact = dc.listContactById(idContact);

        if(contact != null) {
            dc.deleteContact(idContact);
            System.out.println("Contato excluído com sucesso");
        } else {
            System.out.println("Usuário não encontrado");
        }

    }

    static void updateContact(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o código do contato para alteração: ");
        int idContact = sc.nextInt();
        sc.nextLine();

        DaoContact dc = new DaoContact();
        Contact contact = dc.listContactById(idContact);

        if(contact != null) {
            System.out.println(contact.toString());

            System.out.println("informe o nome do contato");
            String name = sc.nextLine();

            System.out.println("informe o email do contato");
            String email = sc.nextLine();

            System.out.println("informe o fone do contato");
            String fone = sc.nextLine();

            if (name.isEmpty() || email.isEmpty() || fone.isEmpty()) {
                System.out.println("Todos os campos são obrigatórios. Alteração cancelada.");
                return;
            }

            contact.setName(name);
            contact.setEmail(email);
            contact.setFone(fone);

            if(dc.updateContact(contact)){
                System.out.println("Contato alterado com sucesso");
            } else {
                System.out.println("Contato não encotrado");
            }

        } else {
            System.out.println("Usuário não encontrado");
        }

    }

    static void listById(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o código do contato: ");
        int idContact = sc.nextInt();

        DaoContact dc = new DaoContact();
        Contact contact = dc.listContactById(idContact);

        if(contact != null) {
            System.out.println(contact.toString());
        } else {
            System.out.println("Contato não encontrado");
        }
    }

    static void listAll(){
        DaoContact dc = new DaoContact();
        List<Contact> list = dc.listContact();

        for(Contact ct : list) {
            System.out.println(ct.toString());
        }
    }

    static char menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Menu==========");
        System.out.println("S = Salvar");
        System.out.println("A = Alterar");
        System.out.println("E = Excluir");
        System.out.println("C = Consultar pelo ID");
        System.out.println("L = Listar todos");
        System.out.println("X = Sair do programa");
        return sc.next().toLowerCase().charAt(0);
    }
}
