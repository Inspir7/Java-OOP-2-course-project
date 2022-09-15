package com.company;

public class CommandService {
    private final FileEditor fileEditor;
    private final Validation validation;

    public CommandService() {
        this.validation = new Validation();
        this.fileEditor = new FileEditor();
    }

    public void executeCommand(String command, String fileData) {
        if(validation.isNullOrEmpty(command) || validation.isNullOrEmpty(fileData)){
            System.out.println("Enter a valid command");
            return;
        }

        switch (command) {
            case "open" : fileEditor.open(fileData); break;
            case "close" : fileEditor.close(); break;
            case "save" : fileEditor.save(); break;
            case "save as" : fileEditor.saveAs(fileData); break;
            case "help": fileEditor.help(); break;
            case "print": fileEditor.print(); break;
            case "select": fileEditor.select(Integer.parseInt(fileData)); break;
            case "children": fileEditor.children(Integer.parseInt(fileData)); break;
            case "exit" :
                System.out.println("Exiting the program"); return;
            default:
                System.out.println("Invalid command");
        }
    }
}