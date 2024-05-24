package com.test.model;

// import com.test.model.Prodotto;
// import com.test.model.Utente;
import com.test.dbservice.ProdottoDAO;
import com.test.dbservice.UtenteDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UtenteDAO utenteDAO = new UtenteDAO();
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Inserisci un nuovo utente");
            System.out.println("2. Visualizza tutti gli utenti");
            System.out.println("3. Aggiorna un utente");
            System.out.println("4. Cancella un utente");
            System.out.println("5. Inserisci un nuovo prodotto");
            System.out.println("6. Visualizza tutti i prodotti");
            System.out.println("7. Aggiorna un prodotto");
            System.out.println("8. Cancella un prodotto");
            System.out.println("9. Acquista prodotto");
            System.out.println("10. Versamento");
            System.out.println("11. Visualizza un Utente");
            System.out.println("12. Visualizza un prodotto");
            System.out.println("13. Esci");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (choice) {
                case 1:
                    System.out.print("Inserisci il nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci l'email: ");
                    String email = scanner.nextLine();
                    System.out.print("Inserisci la password: ");
                    String pass = scanner.nextLine();

                    Utente nuovoUtente = new Utente(0, nome, email, pass, 0);
                    utenteDAO.createUtente(nuovoUtente);
                    System.out.println("Utente inserito con successo!");
                    break;

                case 2:
                    List<Utente> utenti = utenteDAO.getAllUtenti();
                    System.out.println("Elenco utenti:");
                    for (Utente utente : utenti) {
                        System.out.println(utente);
                    }
                    break;

                case 3:
                    System.out.print("Inserisci l'ID dell'utente da aggiornare: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline
                    System.out.print("Inserisci il nuovo nome: ");
                    String nuovoNome = scanner.nextLine();
                    System.out.print("Inserisci la nuova email: ");
                    String nuovaEmail = scanner.nextLine();
                    System.out.print("Inserisci la nuova password: ");
                    String nuovaPassword = scanner.nextLine();
                    
                    Utente utenteVecchio = utenteDAO.getUtenteById(idUpdate);
                    System.out.println(utenteVecchio.toString());
                    double bilancio = utenteVecchio.getBalance();
                    Utente utenteDaAggiornare = new Utente(idUpdate, nuovoNome, nuovaEmail, nuovaPassword, bilancio);
                    utenteDAO.updateUtente(utenteDaAggiornare);
                    // System.out.println(utenteDaAggiornare.toString());
                    System.out.println("Utente aggiornato con successo!");
                    break;

                case 4:
                    System.out.print("Inserisci l'ID dell'utente da cancellare: ");
                    int idDelete = scanner.nextInt();
                    utenteDAO.deleteUtente(idDelete);
                    System.out.println("Utente cancellato con successo!");
                    break;


                case 5:
                    System.out.print("Inserisci il nomen del prodotto: ");
                    String nomeP = scanner.nextLine();
                    System.out.print("Inserisci la descrizione: ");
                    String description = scanner.nextLine();
                    System.out.print("Inserisci il prezzo: ");
                    double prezzo = scanner.nextDouble();
                    System.out.print("Inserisci la quantità: ");
                    int stock = scanner.nextInt();
                    System.out.print("Inserisci utenterId: ");
                    int utenteId = scanner.nextInt();
                    
                    Prodotto nuovoProdotto = new Prodotto(0, description, nomeP, prezzo, stock, utenteId);
                    prodottoDAO.createProdotto(nuovoProdotto);
                    System.out.println(nuovoProdotto.printProduct());
                    System.out.println("Prodotto inserito con successo!");
                    break;

                case 6:
                    List<Prodotto> prodotti = prodottoDAO.getAllProdotti();
                    System.out.println("Elenco prodotti disponibili:");
                    for (Prodotto prodotto : prodotti) {
                        System.out.println(prodotto);
                    }
                    break;

                case 7:
                    System.out.print("Inserisci l'ID del prodotto da aggiornare: ");
                    int idUpdateP = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline
                    System.out.print("Inserisci il nuovo nome: ");
                    String nuovoNomeP = scanner.nextLine();
                    System.out.print("Inserisci la nuova descrizione: ");
                    String nuovaDesc = scanner.nextLine();

                    System.out.print("Inserisci il nuovo prezzo: ");
                    double nuovoPrezzo = scanner.nextDouble();

                    System.out.println("Inserisci la nuova quantità: ");
                    int nuovoStock = scanner.nextInt();

                    System.out.println("Inserisci l'id dell'utente associato CORRETTOO: ");
                    int utentId = scanner.nextInt();
                    

                    Prodotto prodottoDaAggiornare = new Prodotto(idUpdateP, nuovaDesc, nuovoNomeP, nuovoPrezzo, nuovoStock, utentId);
                    prodottoDAO.updateProdotto(prodottoDaAggiornare);
                    System.out.println("Prodotto aggiornato con successo!");
                    break;

                case 8:
                    System.out.print("Inserisci l'ID del prodotto da cancellare: ");
                    int idDeleteP = scanner.nextInt();
                    prodottoDAO.deleteProdotto(idDeleteP);
                    System.out.println("Prodotto cancellato con successo!");
                    break;

                case 9:

                break;

                case 10:
                    
                    break;
                
                case 11:
                    System.out.println("Inserisci l'ID di un utente: ");
                    int idSearchU = scanner.nextInt();
                    Utente utenteDaStampare = utenteDAO.getUtenteById(idSearchU);
                    // System.out.println("Eccco le informazioni dell'utente selezionato \n" 
                    //                     + utenteDAO.printUtente(utenteDaStampare));
                    System.out.println(utenteDaStampare);
                    break;

                case 12:
                    System.out.println("Inserisci l'ID di un prodotto: ");
                    int idSearchP = scanner.nextInt();
                    Prodotto prodotto = prodottoDAO.getProdottoById(idSearchP);
                    System.out.println("Eccco il tuo prodotto selezionato \n" + prodotto.printProduct());
                    break;

                case 13:
                    running = false;
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }

        scanner.close();
    }

}