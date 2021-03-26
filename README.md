# Verification-Api

<h3>Maven command to build project </h3>
<ol>
<li> mvn clean : to clean the project</li>
<li>mvn package : to compile all the class and test cases </li>
</ol>

<h3>To run in command prompt </h3>
java -jar target/verificationapi-0.0.1-SNAPSHOT.jar

<h3>Database Configuration</h3>
<p>For demo purpose used in-memory database</p>
<h4>http://localhost:8080/h2-consol</h4>
<table>
<tr>
    <td>JDBC URL </td>
    <td>jdbc:h2:mem:se</td>
</tr>
<tr>
    <td>User Name</td>
    <td>sa</td>
</tr>
<tr>
    <td>Password</td>
    <td>se</td>
</tr>
</table>

<h3>Checking API using Postman </h3>

<h4>Service One </h4>
Http Method : GET <br/>
URL : <u>localhost:8080/</u> <br/>
<u>Response</u> <br>
<pre>
    {
    "question": "Please sum the numbers ",
    "numbers": [
        3,
        4
    ]
}
</pre>

<h4>Create Projects </h4>
Http Method : Post <br/>
URL : <u>localhost:8080/</u> <br/>
<u>Body</u> <br>
<pre> 
{
    "question": "Please sum the numbers ",
    "numbers": [
        3,
        4
        ],
    "answer":7
}
</pre>
<u>Response</u> <br>
<pre>
    Correct Answer
</pre>


