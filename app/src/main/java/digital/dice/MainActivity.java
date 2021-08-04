/* Digital DICE app
        Version : 1.0.0
        Author:Typical Computer Guy(16 yr old as of 2021)
        Instructions: This source code is for educational purposes only
        To install: Search "Digital Dice" on amazon app store , author : Typical Computer Guy
*/
package digital.dice;
//mentioning what package this class belongs to

// Now importing all the necessary classes
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    char sym='⬤';
    Button rollButton; // creating a Button object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // displayed the activity_main layout, which has 9 text views for the dice, 1 text view for displaying integer,a button and 3 images
        fillScreen(' '); // initially the dice displays 0, So, I fill all the text views of the dice with ' '
        updateNumberTV(0);// displaying 0 integer in the number Text View
        rollButton = (Button) findViewById(R.id.rollbutton);

        //Now we have to set an on click listener for the Button rollbutton
        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display(generateRandom());
            }
        }); // In simple terms, this function public void onClick(View view) will get executed once the Button rollbutton is pressed
    }

    public int generateRandom()
    {
        // This Function generates a random number between 1 to 6, both included and returns Integer value
        Random rand = new Random();
        int x;
        while(true)
        {
            x=rand.nextInt(7);
            if(x>=1 && x<=6)
            {
                return x;
            }
        }
    }

    public void fillScreen(char ch)
    {
        //This function is used to fill all the 9 text Views with the character passed as argument to this function
        updateTV(33,ch);
        updateTV(32,ch);
        updateTV(31,ch);
        updateTV(11,ch);
        updateTV(12,ch);
        updateTV(13,ch);
        updateTV(21,ch);
        updateTV(22,ch);
        updateTV(23,ch);
    }

    public void display(int x)
    {
        //This function takes the randomly generated number as argument and displays it in dice format.
        /* For example:
         5:
           _ _ _
          |⬤ _ ⬤|
          |_ ⬤ _|
          |⬤ _ ⬤|
         */
        fillScreen(' ');
        // first , I will fill all the Text Views with blank space ' '
        //now, depending on what number the function got as argument, I will replace the ' ' with '⬤' char in the required places
        switch(x)
        {
            case 1:
                updateNumberTV(1);
                updateTV(22,sym);
                break;
            case 2:
                updateNumberTV(2);
                updateTV(12,sym);
                updateTV(32,sym);
                break;
            case 3:
                updateNumberTV(3);
                updateTV(12,sym);
                updateTV(22,sym);
                updateTV(32,sym);
                break;
            case 4:
                updateNumberTV(4);
                updateTV(13,sym);
                updateTV(31,sym);
                updateTV(11,sym);
                updateTV(33,sym);
                break;
            case 5:
                updateNumberTV(5);
                updateTV(13,sym);
                updateTV(31,sym);
                updateTV(11,sym);
                updateTV(33,sym);
                updateTV(22,sym);
                break;
            case 6:
                updateNumberTV(6);
                updateTV(33,sym);
                updateTV(32,sym);
                updateTV(31,sym);
                updateTV(11,sym);
                updateTV(12,sym);
                updateTV(13,sym);
                break;
        }
    }

    public void updateNumberTV(int x)
    {
        // This displays the randomly generated number in Integer format
        // for example, if there is a single dot on the centre of the dice this text view will display 1
        String str=Integer.toString(x);
        TextView tvmsg = (TextView) findViewById(R.id.msgtv);
        tvmsg.setText(str);
    }

    public void updateTV(int coor,char symbol)
    {
        // this function takes the coordinate of the text view to be changed and also the symbol to be placed in that coordinate
        // the coordinate system is from 1-3 (x) and 1-3(y), just like x,y coordinates but starting from 1
        // so 11 i the bottom left text view and 22 is the text view in the middle
        String x =""+symbol;
        switch (coor) {
            case 11:
                TextView textview11 = (TextView) findViewById(R.id.tv11);
                textview11.setText(x);
                break;
            case 12:
                TextView textview12 = (TextView) findViewById(R.id.tv12);
                textview12.setText(x);
                break;
            case 13:
                TextView textview13 = (TextView) findViewById(R.id.tv13);
                textview13.setText(x);
                break;
            case 21:
                TextView textview21 = (TextView) findViewById(R.id.tv21);
                textview21.setText(x);
                break;
            case 22:
                TextView textview22 = (TextView) findViewById(R.id.tv22);
                textview22.setText(x);
                break;
            case 23:
                TextView textview23 = (TextView) findViewById(R.id.tv23);
                textview23.setText(x);
                break;
            case 31:
                TextView textview31 = (TextView) findViewById(R.id.tv31);
                textview31.setText(x);
                break;
            case 32:
                TextView textview32 = (TextView) findViewById(R.id.tv32);
                textview32.setText(x);
                break;
            case 33:
                TextView textview33 = (TextView) findViewById(R.id.tv33);
                textview33.setText(x);
                break;
        }
        // Note: I have to add break statement in ever switch case because of a concept called fallthrough
    }
}