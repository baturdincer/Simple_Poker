public class Game {
    Deck deck= new Deck();
    Hand player1hand=new Hand("temp");
    Hand player2hand=new Hand("temp2");
    Hand krupiye=new Hand("Krupiye");
    Hand p1f;
    Hand p2f;
    Hand tie= new Hand("tie");

    boolean p1rfc =false;
    boolean p2rfc =false;
    boolean p1sfc =false;
    boolean p2sfc =false;
    boolean p1fouroakc = false;
    boolean p2fouroakc = false;
    boolean p1fhc=false;
    boolean p2fhc=false;
    int p1fhval3;
    int p1fhval2;
    int p2fhval3;
    int p2fhval2;
    boolean p1fc= false;
    boolean p2fc= false;
    boolean p1sc=false;
    boolean p2sc=false;
    boolean p1threeoakc=false;
    int p1threeoakval3;
    int p1threeoakodd1;
    int p1threeoakodd2;
    boolean p2threeoakc=false;
    int p2threeoakval3;
    int p2threeoakodd1;
    int p2threeoakodd2;
    boolean p1tpc=false;
    boolean p2tpc=false;

    int p1tpodd;
    int p1tp2val1;
    int p1tp2val2;
    int p2tpodd;
    int p2tp2val1;
    int p2tp2val2;
    boolean p1pc=false;
    boolean p2pc=false;
    int p1p2val;
    int p1podd1;
    int p1podd2;
    int p1podd3;
    int p2p2val;
    int p2podd1;
    int p2podd2;
    int p2podd3;




    public Game() {
        deck.shuffle();
        for (int i=0;i<3;i++){
            player1hand.addCard(deck.dealCard());
            player2hand.addCard(deck.dealCard());
        }
        krupiye.addCard(deck.dealCard());
        krupiye.addCard(deck.dealCard());
        krupiye.addCard(deck.dealCard());
        p1f=new Hand("Player 1");
        p2f=new Hand("Player 2");
        for (int i=0;i<5;i++){
            if (i<2){
                p1f.addCard(player1hand.getCard(i));
                p2f.addCard(player2hand.getCard(i));
            }
            else{
                p1f.addCard(krupiye.getCard(i-2));
                p2f.addCard(krupiye.getCard(i-2));
            }
        }
        royalFlush();
        straightflush();
        fouroak();
        fullhouse();
        flush();
        straight();
        threeoak();
        twopair();
        pair();
    }
    public String  wincheck(){
        if (p1rfc||p2rfc){
            return royalFlush().playername+" wins";
        }
        else if(p1sfc||p2sfc){
            return straightflush().playername+ " wins";
        }
        else if (p1fouroakc||p2fouroakc){
            return fouroak().playername+ " wins";
        }
        else if (p1fhc||p2fhc){
            return fullhouse().playername+ " wins";
        }
        else if (p1fc||p2fc){
            return flush().playername+ " wins";
        }
        else if(p1sc||p2sc){
            return straight().playername+ " wins";
        }
        else if (p1threeoakc||p2threeoakc){
            return threeoak().playername+ " wins";
        }
        else if (p1tpc||p2tpc){
            return twopair().playername+ " wins";
        }
        else if (p1pc||p2pc){
            return pair().playername+ " wins pair";
        }
        else return highcard().playername+ " wins highcard";
    }

    public Hand royalFlush(){
        p1f.sortBySuit();
        p2f.sortBySuit();
        if (p1f.getCard(0).getSuit()==p1f.getCard(4).getSuit()){
            if (p1f.getCard(4).getValue()==13&&p1f.getCard(1).getValue()==10&&p1f.getCard(0).getValue()==1&&p1f.getCard(3).getValue()==12&&p1f.getCard(2).getValue()==11){
                this.p1rfc =true;
            }
        }
        if (p2f.getCard(0).getSuit()==p2f.getCard(4).getSuit()){
            if (p2f.getCard(4).getValue()==13&&p2f.getCard(1).getValue()==10&&p2f.getCard(0).getValue()==1&&p2f.getCard(3).getValue()==12&&p2f.getCard(2).getValue()==11){
                this.p2rfc =true;
            }
        }
        if (p1rfc || p2rfc){
            if (p1rfc){
                if (p2rfc){
                    if (p1f.getCard(0).getSuit()<p2f.getCard(0).getSuit()){
                        return p1f;
                    }
                    else{
                        return p2f;
                    }
                }
                else{
                    return p1f;
                }
            }
            else{
                return p2f;
            }
        }
        else {
            return null;
        }
    }
    public Hand straightflush(){
        p1f.sortBySuit();
        p2f.sortBySuit();
        if (p1f.getCard(0).getSuit()==p1f.getCard(4).getSuit()){
            if (p1f.getCard(0).getValue()==p1f.getCard(4).getValue()-4){
                this.p1sfc =true;
                for (int g=1;g<5;g++){
                    if (p1f.getCard(g-1).getValue()==p1f.getCard(g).getValue()){
                        this.p1sfc=false;
                    }
                }
            }
        }
        if (p2f.getCard(0).getSuit()==p2f.getCard(4).getSuit()){
            if (p2f.getCard(0).getValue()==p2f.getCard(4).getValue()-4){
                this.p2sfc =true;
                for (int g=1;g<5;g++){
                    if (p2f.getCard(g-1).getValue()==p2f.getCard(g).getValue()){
                        this.p2sfc=false;
                    }
                }
            }
        }
        if (p1sfc || p2sfc){
            if (p1sfc){
                if (p2sfc){
                    if (p1f.getCard(4).getValue()>p2f.getCard(4).getValue()){
                        return p1f;
                    }
                    else {
                        return p2f;
                    }
                }
                else {
                    return p1f;
                }
            }
            else {
                return p2f;
            }
        }
        else{
            return null;
        }
    }

    public Hand fouroak(){
        p1f.sortByValue();
        p2f.sortByValue();
        if (p1f.getCard(0).getValue()==p1f.getCard(3).getValue()||p1f.getCard(1).getValue()==p1f.getCard(4).getValue()){
            this.p1fouroakc =true;
        }
        if (p2f.getCard(0).getValue()==p2f.getCard(3).getValue()||p2f.getCard(1).getValue()==p2f.getCard(4).getValue()){
            this.p2fouroakc =true;
        }
        if (p1fouroakc || p2fouroakc){
            if (p1fouroakc){
                if (p2fouroakc){
                    if (p1f.getCard(2).getValue()>p2f.getCard(2).getValue()){
                        if (p2f.getCard(2).getValue()==1){
                            return p2f;
                        }
                        else{
                            return p1f;
                        }
                    }
                    else {
                        return p2f;
                    }
                }
                else {
                    return p1f;
                }
            }
            else {
                return p2f;
            }
        }
        else{
            return null;
        }
    }

    public Hand fullhouse(){
        p1f.sortByValue();
        p2f.sortByValue();
        if (p1f.getCard(0).getValue()==p1f.getCard(2).getValue()&&p1f.getCard(3)==p1f.getCard(4)){
            p1fhval3=p1f.getCard(0).getValue();
            p1fhval2=p1f.getCard(4).getValue();
            this.p1fhc=true;
        }
        else if (p1f.getCard(0).getValue()==p1f.getCard(1).getValue()&&p1f.getCard(2)==p1f.getCard(4)) {
            p1fhval3=p1f.getCard(4).getValue();
            p1fhval2=p1f.getCard(0).getValue();
            this.p1fhc=true;
        }
        if (p2f.getCard(0).getValue()==p2f.getCard(2).getValue()&&p2f.getCard(3)==p2f.getCard(4)){
            p2fhval3=p2f.getCard(0).getValue();
            p2fhval2=p2f.getCard(4).getValue();
            this.p2fhc=true;
        }
        else if (p2f.getCard(0).getValue()==p2f.getCard(1).getValue()&&p2f.getCard(2)==p2f.getCard(4)) {
            p2fhval3=p2f.getCard(4).getValue();
            p2fhval2=p2f.getCard(0).getValue();
            this.p2fhc=true;
        }
        if (p1fhc||p2fhc){
            if (p1fhc){
                if (p2fhc){
                    if (p1fhval3>p2fhval3){
                        if (p2fhval3==1){
                            return p2f;
                        }
                        else {
                            return p1f;
                        }
                    }
                    else if (p2fhval3>p1fhval3) {
                        if (p1fhval3==1){
                            return p1f;
                        }
                        else{
                            return p2f;
                        }
                    }
                    else{
                        if(p1fhval2>p2fhval2){
                            if (p2fhval2==1){
                                return p2f;
                            }
                            else{
                                return p1f;
                            }
                        }
                        else if (p1fhval2<p2fhval2){
                            if (p1fhval2==1){
                                return p1f;
                            }
                            else{
                                return p2f;
                            }
                        }
                        else return tie;
                    }
                }
                else{
                    return p1f;
                }
            }
            else{
                return p2f;
            }
        }
        else return null;
    }
    public Hand flush(){
        p1f.sortBySuit();
        p2f.sortBySuit();
        if (p1f.getCard(0).getSuit()==p1f.getCard(4).getSuit()){
            this.p1fc=true;
        }
        if (p2f.getCard(0).getSuit()==p2f.getCard(4).getSuit()){
            this.p2fc=true;
        }
        if(p1fc||p2fc){
            if (p1fc){
                if (p2fc){
                    for (int x=4;x>=0;x--){
                        if (p1f.getCard(x).getValue()>p2f.getCard(x).getValue()){
                            return p1f;
                        }
                        else if (p2f.getCard(x).getValue()>p1f.getCard(x).getValue()) {
                            return p2f;
                        }
                    }
                    return tie;
                }
                else {
                    return p1f;
                }
            }
            else{
                return p2f;
            }
        }
        else{
            return null;
        }
    }
    public Hand straight(){
        p1f.sortByValue();
        p2f.sortByValue();
        if (p1f.getCard(0).getValue()+4==p1f.getCard(4).getValue()){
            this.p1sc=true;
            for (int g=1;g<5;g++){
                if (p1f.getCard(g-1).getValue()==p1f.getCard(g).getValue()){
                    this.p1sc=false;
                }
            }
        }
        else if (p1f.getCard(4).getValue()==13&&p1f.getCard(1).getValue()==10&&p1f.getCard(0).getValue()==1) {
            this.p1sc=true;
            for (int g=1;g<5;g++){
                if (p1f.getCard(g-1).getValue()==p1f.getCard(g).getValue()){
                    this.p1sc=false;
                }
            }

        }
        if (p2f.getCard(0).getValue()+4==p2f.getCard(4).getValue()){
            this.p2sc=true;
            for (int g=1;g<5;g++){
                if (p2f.getCard(g-1).getValue()==p2f.getCard(g).getValue()){
                    this.p2sc=false;
                }
            }
        }
        else if (p2f.getCard(4).getValue()==13&&p2f.getCard(1).getValue()==10&&p2f.getCard(0).getValue()==1) {
            this.p2sc=true;
            for (int g=1;g<5;g++){
                if (p2f.getCard(g-1).getValue()==p2f.getCard(g).getValue()){
                    this.p2sc=false;
                }
            }
        }

        if (p1sc||p2sc){
            if (p1sc){
                if (p2sc){
                    if (p1f.getCard(4).getValue()>p2f.getCard(4).getValue()){
                        return p1f;
                    }
                    else if(p1f.getCard(4).getValue()<p2f.getCard(4).getValue()){
                        return p2f;
                    }
                    else{
                        return tie;
                    }
                }
                else return p1f;
            }
            else return p2f;
        }
        else return null;
    }
    public Hand threeoak(){
        p1f.sortByValue();
        p2f.sortByValue();
        if (p1f.getCard(0).getValue()==p1f.getCard(1).getValue()&&p1f.getCard(0).getValue()==p1f.getCard(2).getValue()){
            this.p1threeoakc=true;
            p1threeoakodd1=p1f.getCard(4).getValue();
            p1threeoakodd2=p1f.getCard(3).getValue();
            p1threeoakval3=p1f.getCard(0).getValue();
        }
        else if (p1f.getCard(1).getValue()==p1f.getCard(2).getValue()&&p1f.getCard(1).getValue()==p1f.getCard(3).getValue()) {
            this.p1threeoakc=true;
            p1threeoakodd1=p1f.getCard(4).getValue();
            p1threeoakodd2=p1f.getCard(0).getValue();
            p1threeoakval3=p1f.getCard(1).getValue();
        }
        else if(p1f.getCard(2).getValue()==p1f.getCard(3).getValue()&&p1f.getCard(2).getValue()==p1f.getCard(4).getValue()){
            this.p1threeoakc=true;
            p1threeoakodd1=p1f.getCard(1).getValue();
            p1threeoakodd2=p1f.getCard(0).getValue();
            p1threeoakval3=p1f.getCard(2).getValue();
        }
        if (p2f.getCard(0).getValue()==p2f.getCard(1).getValue()&&p2f.getCard(0).getValue()==p2f.getCard(2).getValue()){
            this.p2threeoakc=true;
            p2threeoakodd1=p2f.getCard(4).getValue();
            p2threeoakodd2=p2f.getCard(3).getValue();
            p2threeoakval3=p1f.getCard(0).getValue();
        }
        else if (p2f.getCard(1).getValue()==p2f.getCard(2).getValue()&&p2f.getCard(1).getValue()==p2f.getCard(3).getValue()) {
            this.p2threeoakc=true;
            p2threeoakodd1=p2f.getCard(4).getValue();
            p2threeoakodd2=p2f.getCard(0).getValue();
            p2threeoakval3=p1f.getCard(1).getValue();
        }
        else if(p2f.getCard(2).getValue()==p2f.getCard(3).getValue()&&p2f.getCard(2).getValue()==p2f.getCard(4).getValue()){
            this.p2threeoakc=true;
            p2threeoakodd1=p2f.getCard(1).getValue();
            p2threeoakodd2=p2f.getCard(0).getValue();
            p2threeoakval3=p1f.getCard(2).getValue();
        }
        if (p1threeoakc||p2threeoakc){
            if (p1threeoakc){
                if (p2threeoakc){
                    if (p1threeoakval3>p2threeoakval3){
                        if (p2threeoakval3==1){
                            return p2f;
                        }
                        else return p1f;
                    }
                    else if (p2threeoakval3>p1threeoakval3) {
                        if (p1threeoakval3==1){
                            return p1f;
                        }
                        else return p2f;
                    }

                    else{
                        if (p1threeoakodd1>p2threeoakodd1){
                            if (p2threeoakodd2==1){
                                return p2f;
                            }
                            else return p1f;
                        }
                        else if(p2threeoakodd1>p1threeoakodd1){
                            if (p1threeoakodd2==1){
                                return p1f;
                            }
                            else return p2f;
                        }
                        else if (p1threeoakodd2>p2threeoakodd2){
                            if (p2threeoakodd2==1){
                                return p2f;
                            }
                            else return p1f;
                        }
                        else if(p2threeoakodd2>p1threeoakodd2){
                            if (p1threeoakodd2==1){
                                return p1f;
                            }
                            else return p2f;
                        }
                        else return tie;
                    }
                }
                else return p1f;
            }
            else return p2f;
        }
        else return null;

    }
    public Hand twopair(){
        p1f.sortByValue();
        p2f.sortByValue();
        if (p1f.getCard(0).getValue()==p1f.getCard(1).getValue()&&p1f.getCard(2).getValue()==p1f.getCard(3).getValue()){
            p1tp2val1=p1f.getCard(0).getValue();
            p1tp2val2=p1f.getCard(2).getValue();
            p1tpodd=p1f.getCard(4).getValue();
            this.p1tpc=true;
        }
        else if (p1f.getCard(1).getValue()==p1f.getCard(2).getValue()&&p1f.getCard(3).getValue()==p1f.getCard(4).getValue()){
            p1tp2val1=p1f.getCard(2).getValue();
            p1tp2val2=p1f.getCard(3).getValue();
            p1tpodd=p1f.getCard(0).getValue();
            this.p1tpc=true;
        }
        else if (p1f.getCard(0).getValue()==p1f.getCard(1).getValue()&&p1f.getCard(3).getValue()==p1f.getCard(4).getValue()){
            p1tp2val1=p1f.getCard(0).getValue();
            p1tp2val2=p1f.getCard(3).getValue();
            p1tpodd=p1f.getCard(2).getValue();
            this.p1tpc=true;
        }
        if (p2f.getCard(0).getValue()==p2f.getCard(1).getValue()&&p2f.getCard(2).getValue()==p2f.getCard(3).getValue()){
            p2tp2val1=p2f.getCard(0).getValue();
            p2tp2val2=p2f.getCard(2).getValue();
            p2tpodd=p2f.getCard(4).getValue();
            this.p2tpc=true;
        }
        else if (p2f.getCard(1).getValue()==p2f.getCard(2).getValue()&&p2f.getCard(3).getValue()==p2f.getCard(4).getValue()){
            p2tp2val1=p2f.getCard(1).getValue();
            p2tp2val2=p2f.getCard(3).getValue();
            p2tpodd=p2f.getCard(0).getValue();
            this.p2tpc=true;
        }
        else if (p2f.getCard(1).getValue()==p2f.getCard(2).getValue()&&p2f.getCard(3).getValue()==p2f.getCard(4).getValue()){
            p2tp2val1=p2f.getCard(2).getValue();
            p2tp2val2=p2f.getCard(3).getValue();
            p2tpodd=p2f.getCard(0).getValue();
            this.p2tpc=true;
        }
        if (p1tpc||p2tpc){
            if (p1tpc){
                if (p2tpc){
                    if (p1tp2val2>p2tp2val2){
                        if (p2tp2val1==1){
                            return p2f;
                        }
                        return p1f;
                    }
                    else if(p2tp2val2>p1tp2val2){
                        if (p1tp2val1==1){
                            return p1f;
                        }
                        return p2f;
                    }
                    else {
                        if (p1tp2val1>p2tp2val1){
                            if (p2tp2val1==1){
                                return p2f;
                            }
                            return p1f;
                        }
                        else if(p2tp2val1>p1tp2val1){
                            if (p1tp2val1==1){
                                return p1f;
                            }
                            return p2f;
                        }
                        else{
                            if (p1tpodd>p2tpodd){
                                if (p2tpodd==1){
                                    return p2f;
                                }
                                return p1f;
                            }
                            else if(p2tpodd>p1tpodd){
                                if (p1tpodd==1){
                                    return p1f;
                                }
                                return p2f;
                            }
                            else return tie;
                        }
                    }
                }
                else return p1f;
            }
            else return p2f;
        }
        else return null;

    }


    public Hand pair(){
        p1f.sortByValue();
        p2f.sortByValue();
        if (p1f.getCard(0).getValue()==p1f.getCard(1).getValue()){
            this.p1pc=true;
            p1p2val=p1f.getCard(1).getValue();
            p1podd1=p1f.getCard(2).getValue();
            p1podd2=p1f.getCard(3).getValue();
            p1podd3=p1f.getCard(4).getValue();
        }
        else if (p1f.getCard(1).getValue()==p1f.getCard(2).getValue()){
            this.p1pc=true;
            p1p2val=p1f.getCard(1).getValue();
            p1podd1=p1f.getCard(0).getValue();
            p1podd2=p1f.getCard(3).getValue();
            p1podd3=p1f.getCard(4).getValue();
        }
        else if (p1f.getCard(2).getValue()==p1f.getCard(3).getValue()){
            this.p1pc=true;
            p1p2val=p1f.getCard(3).getValue();
            p1podd1=p1f.getCard(0).getValue();
            p1podd2=p1f.getCard(1).getValue();
            p1podd3=p1f.getCard(4).getValue();
        }
        else if (p1f.getCard(3).getValue()==p1f.getCard(4).getValue()){
            this.p1pc=true;
            p1p2val=p1f.getCard(3).getValue();
            p1podd1=p1f.getCard(0).getValue();
            p1podd2=p1f.getCard(1).getValue();
            p1podd3=p1f.getCard(2).getValue();
        }
        if (p2f.getCard(0).getValue()==p2f.getCard(1).getValue()){
            this.p2pc=true;
            p2p2val=p2f.getCard(1).getValue();
            p2podd1=p2f.getCard(2).getValue();
            p2podd2=p2f.getCard(3).getValue();
            p2podd3=p2f.getCard(4).getValue();
        }
        else if (p2f.getCard(1).getValue()==p2f.getCard(2).getValue()){
            this.p2pc=true;
            p2p2val=p2f.getCard(1).getValue();
            p2podd1=p2f.getCard(0).getValue();
            p2podd2=p2f.getCard(3).getValue();
            p2podd3=p2f.getCard(4).getValue();
        }
        else if (p2f.getCard(2).getValue()==p2f.getCard(3).getValue()){
            this.p2pc=true;
            p2p2val=p2f.getCard(3).getValue();
            p2podd1=p2f.getCard(0).getValue();
            p2podd2=p2f.getCard(1).getValue();
            p2podd3=p2f.getCard(4).getValue();
        }
        else if (p2f.getCard(3).getValue()==p2f.getCard(4).getValue()){
            this.p2pc=true;
            p2p2val=p2f.getCard(3).getValue();
            p2podd1=p2f.getCard(0).getValue();
            p2podd2=p2f.getCard(1).getValue();
            p2podd3=p2f.getCard(2).getValue();
        }
        if (p1pc||p2pc){
            if (p1pc){
                if (p2pc) {
                    if (p1p2val>p2p2val){
                        if (p2p2val==1){
                            return p2f;
                        }
                        else return p1f;
                    }
                    else if (p2p2val>p1p2val){
                        if (p1p2val==1){
                            return p1f;
                        }
                        else return p2f;
                    }
                    else {
                        if (p1podd3>p2podd3){
                            if (p2podd1==1){
                                if(p1podd1!=1){
                                    return p2f;
                                }
                                else return p1f;
                            }
                            else return p1f;
                        }
                        else if (p2podd3>p1podd3){
                            if (p1podd1==1){
                                if (p2podd1!=1){
                                    return p1f;
                                }
                                else return p2f;
                            }
                            else return p2f;
                        }
                        else {
                            if (p1podd2>p2podd2){
                                if (p2podd1==1){
                                    if (p1podd1!=1){
                                        return p2f;
                                    }
                                    else return p1f;
                                }
                                else return p1f;
                            }
                            else if (p2podd2>p1podd2){
                                if (p1podd1==1){
                                    if (p2podd1!=1){
                                        return p1f;
                                    }
                                    else return p2f;
                                }
                                else return p2f;
                            }
                            else{
                                if (p1podd1>p2podd1){
                                    if (p2podd1==1){
                                        return p2f;
                                    }
                                    else return p1f;
                                }
                                else if (p2podd1>p1podd1){
                                    if (p1podd1==1){
                                        return p1f;
                                    }
                                    else return p2f;
                                }
                                else return tie;
                            }
                        }
                    }
                }
                else return p1f;
            }
            else return p2f;
        }
        else return null;

    }

    public Hand highcard(){
        p1f.sortByValue();
        p2f.sortByValue();
        for (int p=4;p>=0;p--){
            if(p2f.getCard(0).getValue() != 1&&p1f.getCard(0).getValue() != 1) {
                if (p1f.getCard(p).getValue() > p2f.getCard(p).getValue()) {
                    return p1f;
                }
                else if (p2f.getCard(p).getValue() > p1f.getCard(p).getValue()) {
                    return p2f;
                } else if (p1f.getCard(p).getValue() == p2f.getCard(p).getValue() && p == 0) {
                    return tie;
                }
            }
            else{
                if (p1f.getCard(0).getValue() == 1&&p2f.getCard(0).getValue() != 1){
                    return p1f;
                }
                else if(p2f.getCard(0).getValue() == 1&&p1f.getCard(0).getValue() != 1){
                    return p2f;
                }
                else{
                    if (p1f.getCard(p).getValue() > p2f.getCard(p).getValue()) {
                        return p1f;
                    }
                    else if (p2f.getCard(p).getValue() > p1f.getCard(p).getValue()) {
                        return p2f;
                    } else if (p1f.getCard(p).getValue() == p2f.getCard(p).getValue() && p == 0) {
                        return tie;
                    }
                }
            }
        }
        return null;
    }
}
