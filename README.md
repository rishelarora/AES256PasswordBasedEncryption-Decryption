[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AES256PasswordBasedEncryption--Decryption-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3894)

AES256PasswordBasedEncryption-Decryption
A library that lets you use the AES 256 password based encryption/decryption for your android application in the easiest manner.

Example Android application on the play store:
https://play.google.com/store/apps/details?id=aes.secureencryptdecrypt

To get this project into your build:

1. Add the specific repository to your build file:
```
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```
2. Add the dependency in your build file
```
dependencies {
    compile 'com.github.rishelarora:AES256PasswordBasedEncryption-Decryption:717dccc0ec'
}
```
USAGE:

1. Initialise a SecureMyText object with following syntax
```
SecureMyText secure=new SecureMyText(context,String password for encryption);
```
2. Use the created object to perform encryption.

<b>This is just to see the encrypted text. DONT send this to server. The final text to be sent needs to contain salt and IV for that instance of communication to be successful.</b>

```
String encrypted_text = secure.encrypt(string to be encrypted);
```
3. For getting final encrypted text containing salt and IV to be transferred,

<b>Send the following string to Server.</b>
```
String encrypted_text_to_be_transferred = secure.EncryptToFinalTransferText(string to be encrypted);
```
<em>A potential hacker now needs to obtain the salt, IV, your inital text password and number of iterations to decrypt this text. Even if he/she succeeds for the next attempt, the salt and IV are again randomised and the other 2 parameters can be changed on both server and client sides so it doesn't compromise the whole system.</em>

4.For decrypting initialization remains the same

```
String plain_text = secure.decrypt(string to be decrypted);
```

For more details look into the SecureText class. The sample folder has an android application that shows a sample implementation of the encryption/decryption.
Explanation of the whole encryption and decryption process taking example of app to server communication with notes and flow diagrams is attached.

Happy securing!
