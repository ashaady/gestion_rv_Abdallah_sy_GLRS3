package com.ism.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ism.entities.Medecin;

public class MedecinImpl implements IMedecin<Medecin> {
private  DatabaseImpl database;

public MedecinImpl(DatabaseImpl database) {
    this.database = database;
}

    @Override
    public int insert(Medecin medecin) {
        try {
            database.connect();
            String insertQuery = "INSERT INTO personne (nomComplet, type, antecedent, specialite) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = database.getPs(insertQuery);

            preparedStatement.setString(1, medecin.getNomComplet());
            preparedStatement.setInt(2, medecin.getType());
            preparedStatement.setString(3,null);
            preparedStatement.setString(4, medecin.getSpecialite());

            int rowsInserted = database.executeUpdate(preparedStatement);
            database.disconnect();

            return rowsInserted;
        } catch (SQLException e) {
            e.printStackTrace();

            return 0; 
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
}


}
