package API.jdbc.programme;

import java.util.Scanner;

import com.controller.app.MySQLAccess;

public class Main {
  
	public static void main(String[] args)  {
		try {
		String firstName="",description="",cni="", req="";
		int choix,id=0,stat;
		String host = "jdbc:mysql://localhost/youCode_2";
		 String user = "root";
		  String passwd = "";
	    MySQLAccess dao = new MySQLAccess();

	  Scanner input = new Scanner(System.in);
	
	//Ajouter 
	System.out.println("***********Welcom************");
	System.out.println("Gestio etudient");
	
	while(true) {
	System.out.println("Ajouter etudient => 1 \n Modifier etudient => 2 \n afficher etudient => 3 \n supprimer etudient => 4 \n recherch etudient => 5");
	choix = input.nextInt();
	switch(choix) {
	case 1 :	
		//Ajouter
		System.out.println("Enter le nom de etudient .");
		firstName= input.next("^[a-zA-Z]{8}/$");
		System.out.println("Enter le description de etudient .");
		description= input.next("[a-zA-Z0-9]{12,16}$");
		System.out.println("Enter le cni de etudient");
		cni= input.next();
		req="INSERT INTO youcode(nom,description,cni) VALUES(?,?,?)";
		stat=dao.Etudient(req, id, firstName, description, cni,"Add");
	if(stat!=0) {
		System.out.println(stat + " row/s affected");
	}else {
		System.out.println("Sorry not affected");
	}
	break;
	case 2 :
		//Modifier
		System.out.println("Enter le id de etudient qui va modifier .");
		id= input.nextInt();
		System.out.println("Enter le nom de etudient .");
		firstName= input.next("^[a-zA-Z]{8}/$");
		System.out.println("Enter le description de etudient .");
		description= input.next("[a-zA-Z0-9]{12,16}$");
		System.out.println("Enter le cni de etudient");
		cni= input.next();
		//stat= dao.SupprmerEtudient(id);
		req="UPDATE youcode SET nom=?,description=?,cni=? WHERE id =?";
		stat= dao.Etudient(req, id, firstName, description, cni,"update");
		if(stat!=0) {
			System.out.println(stat + " row/s modifier");
		}else {
			System.out.println("Sorry not update");
		}
		break;
		
	case 3:
		//Afficher
		 dao.afficherListEtudient();
		break;
	case 4:
		//Supprimer
		System.out.println("Enter le id de etudient qui va supprimer .");
		id= input.nextInt();
		 stat=dao.SupprmerEtudient(id);
		 if(stat!=0) {
				System.out.println(stat + " row/s supprimer");
			}else {
				System.out.println("Sorry not delected");
			}
		break;
	case 5:
		//Rechercher
		System.out.println("Entre le nom");
		firstName= input.next();
		dao.RecherchEtudient(firstName);
		break;
	
		
	}
	}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}
}
