package sms.dbz.com.secretmessageservice;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class de1 extends Activity {
    String[] algorithm;
  IntentFilter intentFilter;
    private BroadcastReceiver intentReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            EditText et=(EditText)findViewById(R.id.editText6);
            et.setText(intent.getExtras().getString("rec"));
            TextView tv=(TextView)findViewById(R.id.textView5);
            tv.setText(intent.getExtras().getString("rec"));
        }
    };
    String cacide(String cipherText, String shiftKey) {
        /*
        String decrypted = "";
        for (int i = 0; i < s.length(); i++) {
            //stores ascii value of character in the string at index 'i'
            int c = s.charAt(i);
            int keyLength = Integer.parseInt(ke);
            //encryption logic for uppercase letters
            if (Character.isUpperCase(c)) {
                c = c -(keyLength % 26);
                //if c value exceeds the ascii value of 'Z' reduce it by subtracting 26(no.of alphabets) to keep in boundaries of ascii values of 'A' and 'Z'
                if (c > 'Z')
                    c = c - 26;
            }
            //encryption logic for lowercase letters
            else if (Character.isLowerCase(c)) {
                c = c - (keyLength % 26);
                //if c value exceeds the ascii value of 'z' reduce it by subtracting 26(no.of alphabets) to keep in boundaries of ascii values of 'a' and 'z'
                if (c > 'z')
                    c = c - 26;
            }
            //concatinate the encrypted characters/strings
            decrypted = decrypted +(char)c;

        }
        return decrypted;*/
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        int k=Integer.parseInt(shiftKey);
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - k) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }

    String moalde(String s) {
        char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z' };
        char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
                'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
                'V', 'B', 'N', 'M' };
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }


    public class PlayfairCipherDecryption
    {
        private String KeyWord        = new String();
        private String Key            = new String();
        private char   matrix_arr[][] = new char[5][5];

        public void setKey(String k)
        {
            String K_adjust = new String();
            boolean flag = false;
            K_adjust = K_adjust + k.charAt(0);
            for (int i = 1; i < k.length(); i++)
            {
                for (int j = 0; j < K_adjust.length(); j++)
                {
                    if (k.charAt(i) == K_adjust.charAt(j))
                    {
                        flag = true;
                    }
                }
                if (flag == false)
                    K_adjust = K_adjust + k.charAt(i);
                flag = false;
            }
            KeyWord = K_adjust;
        }

        public void KeyGen()
        {
            boolean flag = true;
            char current;
            Key = KeyWord;
            for (int i = 0; i < 26; i++)
            {
                current = (char) (i + 97);
                if (current == 'j')
                    continue;
                for (int j = 0; j < KeyWord.length(); j++)
                {
                    if (current == KeyWord.charAt(j))
                    {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    Key = Key + current;
                flag = true;
            }
            System.out.println(Key);
            matrix();
        }

        private void matrix()
        {
            int counter = 0;
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    matrix_arr[i][j] = Key.charAt(counter);
                    System.out.print(matrix_arr[i][j] + " ");
                    counter++;
                }
                System.out.println();
            }
        }

        private String format(String old_text)
        {
            int i = 0;
            int len = 0;
            String text = new String();
            len = old_text.length();
            for (int tmp = 0; tmp < len; tmp++)
            {
                if (old_text.charAt(tmp) == 'j')
                {
                    text = text + 'i';
                }
                else
                    text = text + old_text.charAt(tmp);
            }
            len = text.length();
            for (i = 0; i < len; i = i + 2)
            {
                if (text.charAt(i + 1) == text.charAt(i))
                {
                    text = text.substring(0, i + 1) + 'x' + text.substring(i + 1);
                }
            }
            return text;
        }

        private String[] Divid2Pairs(String new_string)
        {
            String Original = format(new_string);
            int size = Original.length();
            if (size % 2 != 0)
            {
                size++;
                Original = Original + 'x';
            }
            String x[] = new String[size / 2];
            int counter = 0;
            for (int i = 0; i < size / 2; i++)
            {
                x[i] = Original.substring(counter, counter + 2);
                counter = counter + 2;
            }
            return x;
        }

        public int[] GetDiminsions(char letter)
        {
            int[] key = new int[2];
            if (letter == 'j')
                letter = 'i';
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    if (matrix_arr[i][j] == letter)
                    {
                        key[0] = i;
                        key[1] = j;
                        break;
                    }
                }
            }
            return key;
        }

        public String encryptMessage(String Source)
        {
            String src_arr[] = Divid2Pairs(Source);
            String Code = new String();
            char one;
            char two;
            int part1[] = new int[2];
            int part2[] = new int[2];
            for (int i = 0; i < src_arr.length; i++)
            {
                one = src_arr[i].charAt(0);
                two = src_arr[i].charAt(1);
                part1 = GetDiminsions(one);
                part2 = GetDiminsions(two);
                if (part1[0] == part2[0])
                {
                    if (part1[1] < 4)
                        part1[1]++;
                    else
                        part1[1] = 0;
                    if (part2[1] < 4)
                        part2[1]++;
                    else
                        part2[1] = 0;
                }
                else if (part1[1] == part2[1])
                {
                    if (part1[0] < 4)
                        part1[0]++;
                    else
                        part1[0] = 0;
                    if (part2[0] < 4)
                        part2[0]++;
                    else
                        part2[0] = 0;
                }
                else
                {
                    int temp = part1[1];
                    part1[1] = part2[1];
                    part2[1] = temp;
                }
                Code = Code + matrix_arr[part1[0]][part1[1]]
                        + matrix_arr[part2[0]][part2[1]];
            }
            return Code;
        }

        public String decryptMessage(String Code)
        {
            String Original = new String();
            String src_arr[] = Divid2Pairs(Code);
            char one;
            char two;
            int part1[] = new int[2];
            int part2[] = new int[2];
            for (int i = 0; i < src_arr.length; i++)
            {
                one = src_arr[i].charAt(0);
                two = src_arr[i].charAt(1);
                part1 = GetDiminsions(one);
                part2 = GetDiminsions(two);
                if (part1[0] == part2[0])
                {
                    if (part1[1] > 0)
                        part1[1]--;
                    else
                        part1[1] = 4;
                    if (part2[1] > 0)
                        part2[1]--;
                    else
                        part2[1] = 4;
                }
                else if (part1[1] == part2[1])
                {
                    if (part1[0] > 0)
                        part1[0]--;
                    else
                        part1[0] = 4;
                    if (part2[0] > 0)
                        part2[0]--;
                    else
                        part2[0] = 4;
                }
                else
                {
                    int temp = part1[1];
                    part1[1] = part2[1];
                    part2[1] = temp;
                }
                Original = Original + matrix_arr[part1[0]][part1[1]]
                        + matrix_arr[part2[0]][part2[1]];
            }
            return Original;
        }}
    public static String pode(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public class TranspositionCipher {
        public String selectedKey;
        public char sortedKey[];
        public int sortedKeyPos[];

        // default constructor define the default key
        public TranspositionCipher() {
            selectedKey = "megabuck";
            sortedKeyPos = new int[selectedKey.length()];
            sortedKey = selectedKey.toCharArray();
        }

        // Parameterized constructor define the custom key
        public TranspositionCipher(String myKey) {
            selectedKey = myKey;
            sortedKeyPos = new int[selectedKey.length()];
            sortedKey = selectedKey.toCharArray();
        }

        // To reorder data do the sorting on selected key
        public void doProcessOnKey() {
            // Find position of each character in selected key and arrange it on
            // alphabetical order
            int min, i, j;
            char orginalKey[] = selectedKey.toCharArray();
            char temp;
            // First Sort the array of selected key
            for (i = 0; i < selectedKey.length(); i++) {
                min = i;
                for (j = i; j < selectedKey.length(); j++) {
                    if (sortedKey[min] > sortedKey[j]) {
                        min = j;
                    }
                }
                if (min != i) {
                    temp = sortedKey[i];
                    sortedKey[i] = sortedKey[min];
                    sortedKey[min] = temp;
                }
            }
            // Fill the position of array according to alphabetical order
            for (i = 0; i < selectedKey.length(); i++) {
                for (j = 0; j < selectedKey.length(); j++) {
                    if (orginalKey[i] == sortedKey[j])
                        sortedKeyPos[i] = j;
                }
            }
        }

        // to encrypt the targeted string
        public String doEncryption(String plainText) {
            int min, i, j;
            char orginalKey[] = selectedKey.toCharArray();
            char temp;
            doProcessOnKey();
            // Generate encrypted message by doing encryption using Transpotion
            // Cipher
            int row = plainText.length() / selectedKey.length();
            int extrabit = plainText.length() % selectedKey.length();
            int exrow = (extrabit == 0) ? 0 : 1;
            int rowtemp = -1, coltemp = -1;
            int totallen = (row + exrow) * selectedKey.length();
            char pmat[][] = new char[(row + exrow)][(selectedKey.length())];
            char encry[] = new char[totallen];
            int tempcnt = -1;
            row = 0;
            for (i = 0; i < totallen; i++) {
                coltemp++;
                if (i < plainText.length()) {
                    if (coltemp == (selectedKey.length())) {
                        row++;
                        coltemp = 0;
                    }
                    pmat[row][coltemp] = plainText.charAt(i);
                } else { // do the padding ...
                    pmat[row][coltemp] = '*';
                }
            }
            int len = -1, k;
            for (i = 0; i < selectedKey.length(); i++) {
                for (k = 0; k < selectedKey.length(); k++) {
                    if (i == sortedKeyPos[k]) {
                        break;
                    }
                }
                for (j = 0; j <= row; j++) {
                    len++;
                    encry[len] = pmat[j][k];
                }
            }
            String p1 = new String(encry);
            return (new String(p1));
        }

        // to decrypt the targeted string
        public String doDecryption(String s) {
            int min, i, j, k;
            char key[] = selectedKey.toCharArray();
            char encry[] = s.toCharArray();
            char temp;
            doProcessOnKey();
            // Now generating plain message
            int row = s.length() / selectedKey.length();
            char pmat[][] = new char[row][(selectedKey.length())];
            int tempcnt = -1;
            for (i = 0; i < selectedKey.length(); i++) {
                for (k = 0; k < selectedKey.length(); k++) {
                    if (i == sortedKeyPos[k]) {
                        break;
                    }
                }
                for (j = 0; j < row; j++) {
                    tempcnt++;
                    pmat[j][k] = encry[tempcnt];
                }
            }
            // store matrix character in to a single string
            char p1[] = new char[row * selectedKey.length()];
            k = 0;
            for (i = 0; i < row; i++) {
                for (j = 0; j < selectedKey.length(); j++) {
                    if (pmat[i][j] != '*') {
                        p1[k++] = pmat[i][j];
                    }
                }
            }
            p1[k++] = '\0';
            return (new String(p1));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de1);
        intentFilter=new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");
        registerReceiver(intentReceiver, intentFilter);
        algorithm = getResources().getStringArray(R.array.algorithm_array);
        EditText et = (EditText) findViewById(R.id.editText6);
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        { String ct=extras.getString("DEDI");
            et.setText(ct);}
        Spinner s2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, algorithm);
        s2.setAdapter(adapter);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final int index=arg0.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "You have selected :" + algorithm[index], Toast.LENGTH_SHORT).show();
                Button b2 = (Button) findViewById(R.id.button8);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String plain="NULL";
                        EditText et = (EditText) findViewById(R.id.editText6);
                        String st = et.getText().toString();
                        EditText et1 = (EditText) findViewById(R.id.editText7);
                        String ke = et1.getText().toString();
                        int flag=0;
                        if (algorithm[index].equals("Caesar Cipher")){flag=0;plain = cacide(st, ke);}
                        else if (algorithm[index].equals("Monoalphabetic")) {
                            if(ke.equals("accept")){flag=0;plain = moalde(st);}
                            else{ Toast.makeText(getBaseContext(),"Please provide the valid KEY to continue",Toast.LENGTH_SHORT).show();
                            flag=1;

                        }}
                        else if (algorithm[index].equals("Play Fair")){
                            PlayfairCipherDecryption x=new PlayfairCipherDecryption();
                            String keyword = ke;
                            x.setKey(keyword);
                            x.KeyGen();
                            String key_input=st;
                            plain=x.decryptMessage(key_input);
                            flag=0;

                        }
                        else if (algorithm[index].equals("Polyalphabetic"))
                        { plain=pode(st,ke);
                            flag=0;
                        }
                        else if (algorithm[index].equals("Transposition"))
                        {
                            TranspositionCipher tc = new TranspositionCipher(ke);
                            plain=tc.doDecryption(st);
                            flag=0;
                        }
                        if(flag==0)
                        {
                        Intent i = new Intent(getBaseContext(), de2.class);
                        i.putExtra("PLA_TEXT", plain);
                        startActivity(i);
                    }
                }});


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Override
    protected void onResume(){
        registerReceiver(intentReceiver,intentFilter);
        super.onResume();
    }
    @Override
    protected void onPause(){
       //unregisterReceiver(intentReceiver);
        super.onPause();
    }
    @Override
    protected void onDestroy()
    {
        unregisterReceiver(intentReceiver);
        super.onDestroy();
    }

}
