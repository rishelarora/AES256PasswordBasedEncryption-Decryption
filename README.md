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

Initialise a SecureMyText object with following syntax
```
SecureMyText secure=new SecureMyText(context,String password for encryption);
```
Use the created object to perform encryption.

For encrypting the text

```
String encrypted_text = secure.encrypt(string to be encrypted);
```
For getting final encrypted text containing salt and IV to be transferred.

```
String encrypted_text_to_be_transferred = secure.EncryptToFinalTransferText(string to be encrypted);
```
For decrypting initialization remains the same

```
String plain_text = secure.decrypt(string to be decrypted);
```

For more details look for the SecureText class in main java folder. All the instructions are given in the file itself. Copy the lightweight class into your project and customise it according to your needs.

The sample folder has the sample android application that shows a sample implementation of the encryption/decryption.

Explaination of the whole encryption and decryption process taking example of app to server communication with notes and flow diagrams is attached.

Happy securing!

*was having some problems on uploading the library on Maven central as the process is not that easy. Will be doing that soon.
