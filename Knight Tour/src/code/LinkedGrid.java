package code;

public class LinkedGrid {

    private Node first;   
    
    public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public LinkedGrid(int dimension) {

        Node temp = null;

        first = new Node(0);
        Node columnMarker = first;
        Node rowMarker = first;

        for (int x = 0; x < dimension - 1; x++) {
            temp = new Node(0);
            columnMarker.setRight(temp);
            temp.setLeft(columnMarker);
            columnMarker = temp;
        }

        for (int q = 0; q < dimension - 1; q++) {
            temp = new Node(0);
            rowMarker.setDown(temp);
            temp.setUp(rowMarker);
            columnMarker = temp;

            for (int x = 0; x < dimension - 1; x++) {
                temp = new Node(0);
                columnMarker.setRight(temp);
                temp.setLeft(columnMarker);
                temp.setUp(columnMarker.getUp().getRight());
                temp.getUp().setDown(temp);
                columnMarker = temp;
            }
            rowMarker = rowMarker.getDown();
        }
    }

    public void display() {
        Node temp = first;
        Node rowMarker = first;

        while (temp != null) {
            while (temp != null) {
                System.out.print(temp.getData());
                
                if(temp.getData() > 9)
                {
                	System.out.print(" ");
                }
                else
                	System.out.print("  ");
                temp = temp.getRight();
            }
            System.out.println();
            rowMarker = rowMarker.getDown();
            temp = rowMarker;
        }
        
        System.out.println("");
    }
}


