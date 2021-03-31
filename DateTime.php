<html>
    <head>
        <title>Date Time Validation</title>
    </head>
    <body>
        <font>Enter your name and select date and time for the appointment</font>
        <br>
        <br>
        <form action="<?php echo $_SERVER["PHP_SELF"]?>" method = "GET">

        <?php
            $userName = $_GET["userName"];
            $month = $_GET["month"];
            $day = $_GET["day"];
            $year = $_GET["year"];
            $hour = $_GET["hour"];
            $minute = $_GET["minute"];
            $second = $_GET['second'];
        ?>
        <table>
            <tr>
                <td>Your name:</td>
                <td><input type = "text" size = "10" maxlength="20" name = "userName">
                
                </td>
            </tr>

            <tr>
                <td>Date:</td>
                <td><select name="month">
                    <?php
                    for ($i = 1; $i < 13; $i++) {
                        if ($i == $month)
                            print("<option selected>$i</option>");
                        else
                            print("<option>$i</option>");
                    }
                        
                    ?>
                </td>

                <td><select name="day">
                    <?php
                    for ($i = 1; $i < 32; $i++) {
                        if ($i == $day)
                            print("<option selected>$i</option>");
                        else
                            print("<option>$i</option>");
                    }
                        
                    ?>
                </td>

                <td><select name="year">
                    <?php
                    for ($i = 2021; $i > 1500; $i--) {
                        if ($i == $year)
                            print("<option selected>$i</option>");
                        else
                            print("<option>$i</option>");
                    }
                        
                    ?>
                </td>
            </tr>

            <tr>
                <td>Time:</td>
                <td><select name="hour">
                    <?php
                    for ($i = 0; $i < 24; $i++) {
                        if ($i == $hour)
                            print("<option selected>$i</option>");
                        else
                            print("<option>$i</option>");
                    }
                    ?>
                </td>

                <td><select name="minute">
                    <?php
                    for ($i = 0; $i < 61; $i++) {
                        if ($i == $minute)
                            print("<option selected>$i</option>");
                        else
                            print("<option>$i</option>");
                    }
                    ?>
                </td>

                <td><select name="second">
                    <?php
                    for ($i = 0; $i < 61; $i++) {
                        if ($i == $second)
                            print("<option selected>$i</option>");
                        else
                            print("<option>$i</option>");
                    }
                    ?>
                </td>
            </tr>

            <tr>
                    <td align="right"><INPUT type="submit" value="Submit"></td>
                    <td align="left"><input type="reset" value="Reset"></td>
                </tr>
        </table>

        <?php
            print("Hi $userName!<br>" );
            print("You have choose to have an appointment on $hour:$minute:$second, $month/$day/$year<br>");
            print("<br>More information<br><br>");
            if ($hour < 12)
                    print("In 12 hours, the time and date is $hour:$minute:$second AM, $month/$day/$year<br>");
            else {
                $hour -= 12;
                print("In 12 hours, the time and date is $hour:$minute:$second PM, $month/$day/$year<br>");
            }
            switch ($month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: 
                    print("<br>This month has 31 days!");
                    break;
                case 4:
                case 6:
                case 9:
                case 11: 
                    print("<br>This month has 30 days!");
                    break;
                case 2:
                    if ($year % 400 == 0 || ($year % 4 == 0 && $year % 100 != 0))
                        print("<br>This month has 29 days!");
                    else
                        print("<br>This month has 28 days!");
                    
            }

        ?>
    </body>
</html>