package by.bsu.example.command.client;

import by.bsu.example.command.ActionCommand;
import by.bsu.example.command.LogoutCommand;
import by.bsu.example.command.Step1Command;
import by.bsu.example.command.Step2Command;

public enum CommandEnum {
	STEP1 {
		{
			this.command = new Step1Command();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	STEP2 {
		{
			this.command = new Step2Command();
		}
	};
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}