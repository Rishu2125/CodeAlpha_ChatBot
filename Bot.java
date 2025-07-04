package ChatBot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;





    public class Bot extends JFrame {
        private JTextArea chatArea;
        private JTextField inputField;
        private JButton sendButton;
        private HashMap<String, String> knowledgeBase;

        public Bot() {
            setTitle("Java ChatBot");
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            chatArea = new JTextArea();
            chatArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(chatArea);

            inputField = new JTextField();
            sendButton = new JButton("Send");

            JPanel inputPanel = new JPanel(new BorderLayout());
            inputPanel.add(inputField, BorderLayout.CENTER);
            inputPanel.add(sendButton, BorderLayout.EAST);

            add(scrollPane, BorderLayout.CENTER);
            add(inputPanel, BorderLayout.SOUTH);


            setupKnowledgeBase();


            sendButton.addActionListener(e -> processInput());
            inputField.addActionListener(e -> processInput());
        }

        private void setupKnowledgeBase() {
            knowledgeBase = new HashMap<>();
            knowledgeBase.put("hello", "Hi there! How can I help you?");
            knowledgeBase.put("hi", "Hello! What can I assist you with?");
            knowledgeBase.put("hi i am good", "how are you?");
            knowledgeBase.put("how are you", "I'm just a bot, but I'm doing great!");
            knowledgeBase.put("what is your name", "I'm a Java ChatBot.");
            knowledgeBase.put("help", "You can ask me about my name, greetings, or general info.");
            knowledgeBase.put("bye", "Goodbye! Have a nice day!");
        }

        private void processInput() {
            String userInput = inputField.getText().trim();
            if (userInput.isEmpty()) return;

            chatArea.append("You: " + userInput + "\n");
            String response = getResponse(userInput.toLowerCase());
            chatArea.append("Bot: " + response + "\n");
            inputField.setText("");
        }

        private String getResponse(String input) {

            for (String key : knowledgeBase.keySet()) {
                if (input.contains(key)) {
                    return knowledgeBase.get(key);
                }
            }
            return "Sorry, I didn't understand that. Try asking something else.";
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                Bot bot = new Bot();
                bot.setVisible(true);
            });
        }
    }


