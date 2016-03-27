package by.bsu.example.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
	String execute(HttpServletRequest request) throws SQLException;
}