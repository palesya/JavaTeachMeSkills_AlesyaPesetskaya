package Homework_7.Documents;

public class Register {

    private Document [] documents=new Document[10];

    public Document[] getDocuments() {
        return documents;
    }

    public void saveDocInRegister(Document document){
        for (int i=0;i<documents.length;i++){
            if(documents[i]==null){
                documents[i]=document;
                System.out.println("Document was added to register with position "+(i+1));
                break;
            }
            if(documents[documents.length-1]!=null){
                System.out.println("Register is filled. No document can be added.");
            }
        }
    }
    public void getDocInformation(Document document){
        System.out.println(document);
    }
}
