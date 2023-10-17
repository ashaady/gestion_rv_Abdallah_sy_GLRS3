package com.ism.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ism.entities.Patient;

public class PatientImpl implements IPatient<Patient> {
    private  DatabaseImpl database;

    public PatientImpl(DatabaseImpl database) {
        this.database = database;
    }

    @Override
    public int insert(Patient patient) {
        try {
            database.connect();

            String insertQuery = "INSERT INTO personne (nomComplet, type, antecedent, specialite) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = database.getPs(insertQuery);

            preparedStatement.setString(1, patient.getNomComplet());
            preparedStatement.setInt(2, patient.getType());
            preparedStatement.setString(3, patient.getAntecedents());
            preparedStatement.setString(4, null);

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
