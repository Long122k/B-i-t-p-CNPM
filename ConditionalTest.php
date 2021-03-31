<html>
    <head><title>Conditional Test</title></head>
    <body>
        <?php
        $first = $_GET["firstName"];
        $middle = $_GET["middleName"];
        $last = $_GET["lastName"];
        print("Hi $first! Your full name is $last $middle $first. <br></br>");
        if ($first == $last) {
            print("$first and $last are equal");
        }
        if ($first > $last) {
            print("$first is greater than $last");
        }
        if ($first < $last) {
            print("$first is less than $last");
        }
        print("<br></br>");

        $grade1 = $_GET["grade1"];
        $grade2 = $_GET["grade2"];
        $final = (2 * $grade1 + 3 * $grade2) / 5;
        if ($final > 89) {
            print("Your final score is $final. You got an A. Congratulation!!");
            $rate = "A";
        }
        else if ($final > 79) {
            print("Your final score is $final. You got an B.");
            $rate = "B";
        }
        else if ($final > 69) {
            print("Your final score is $final. You got an C.");
            $rate = "C";
        }
        else if ($final > 59) {
            print("Your final score is $final. You got an D.");
            $rate = "D";
        }
        else if ($final >= 0) {
            print("Your final score is $final. You got an F.");
            $rate = "F";
        }
        else {
            print("Illegal grade less than ). Final grade = $final");
            $rate = "Illegal";
        }
        print("<br></br>");
        switch ($rate) {
            case "A": print("Excellent!"); break;
            case "B": print("Good!"); break;
            case "C": print("Not bad!"); break;
            case "D": print("Normal!"); break;
            case "D":
            case "F": print("You are to try again!"); break;
            default: print("Illegal grade!");
        }
            
        ?>
    </body>
</html>