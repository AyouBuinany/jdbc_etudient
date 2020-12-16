package com.controller.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.configConnection.com.Config;
import com.model.app.Etudient;


public class MySQLAccess {
	  private Statement statement;
	  private Connection connect;
	  private PreparedStatement preparedStatement;
	  private ResultSet resultSet ;
	   Etudient etudient;
	  Config config;
	  public MySQLAccess() throws Exception {
		  config= new Config("jdbc:mysql://localhost/youCode_2","root","");
		  this.statement=null;
		  this.preparedStatement=null;
		  this.resultSet= null;
		  etudient= new Etudient();
		  connect= config.CoonectionLoad();
	  }
	 
	  public void afficherListEtudient() {
		  try {
			statement=connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
			String req= "SELECT * FROM youcode";
			resultSet=statement.executeQuery(req);
		
			while(resultSet.next()) {
				etudient.setId(resultSet.getInt("id"));
				etudient.setFirstName(resultSet.getString("nom"));
				etudient.setCni(resultSet.getString("cni"));
				etudient.setDescription(resultSet.getString("description"));
				//System.out.println( " Number Row " + resultSet.getRow() + " Last " + resultSet.last());
				System.out.println(etudient.toString());

			}
		
		
		
		  }catch (Exception e) {
			  System.out.println(e.getMessage()); 
		  }
		  
	  }
	  /*
	  public int AjouterEtudient(String firstName,String description,String cni) throws SQLException {
		  String req="INSERT INTO youcode(nom,description,cni) VALUES(?,?,?)";
		  //statement= connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
		  PreparedStatement st = connect.prepareStatement(req);
		  st.setString(1, firstName);
		  st.setString(2, description);
		  st.setString(3, cni);
		  int stat= st.executeUpdate();
		 return stat;
	  }
	  */
	  //supprimer Etudient
	  public int SupprmerEtudient(int id) throws SQLException {
		  String req="DELETE FROM youcode WHERE id =?";
		  //statement= connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
		  PreparedStatement st = connect.prepareStatement(req);
		  st.setInt(1, id);
		  int stat= st.executeUpdate();
		 return stat;
	  }
	  //Modifier Etudient
	 /* public int ModifierEtudient(int id,String nom,String description, String cni) throws SQLException {
		  String req="UPDATE youcode SET nom=?,description=?,cni=? WHERE id =?";
		  //statement= connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
		  PreparedStatement st = connect.prepareStatement(req);
		  st.setInt(1, id);
		  st.setString(2, nom);
		  st.setString(3,description);
		  st.setString(4, cni);
		  int stat= st.executeUpdate();
		 return stat;
	  }
	  */
	  //Recherch Etudient
	  public void RecherchEtudient(String nom) throws SQLException {
		  String req="SELECT * FROM youcode WHERE nom='"+ nom +"'";
		  //statement= connect.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE,resultSet.CONCUR_READ_ONLY);
		  statement=connect.createStatement();
		  resultSet = statement.executeQuery(req);
		  
		  while(resultSet.next()) {
			  etudient.setId(resultSet.getInt("id"));
				etudient.setFirstName(resultSet.getString("nom"));
				etudient.setCni(resultSet.getString("cni"));
				etudient.setDescription(resultSet.getString("description"));
			  System.out.println(etudient.toString());
		  }
		 
	  }
	  
	  //Function Etudient pour Ajouter et modifier
	  public int Etudient(String req,int id,String nom,String discription ,String cni,String choix) throws SQLException {
		  
		  PreparedStatement st = connect.prepareStatement(req);
		  if(choix=="Add") {
			  st.setString(1, nom);
			  st.setString(2, discription);
			  st.setString(3, cni);
		  }else 
		if(choix=="update") {
			  st.setString(1, nom);
			  st.setString(2, discription);
			  st.setString(3, cni);
			  st.setInt(4, id);
		  }
		  
		  int stat = st.executeUpdate();
		  return stat;
	  }
	  public void deconnection() throws Exception {
			connect.close();
	  }
	  
}
