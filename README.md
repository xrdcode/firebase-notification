# firebase-notification

## What To Do ##

Pada contoh ini, silahkan setup firebase menggunakan console masing-masing. Kemudian jangan lupa untuk mengganti server key dengan milik sendiri. Server key dapat di temukan pada console firebase, setting > cloud messaging.

## Step By Step ##

1. Setup dependencies firebase, volley.
2. Buat kelas untuk menyimpan statik variabel, misal kelas Constant
3. Buat MessagingService extend FirebaseMessagingService
4. Buat FirebaseIDService extend FirebaseInstanceIdService
5. Core send notification ada di MessagingService.sendNotification();

## How to Use :
`MessagingService.sendNotification(notifBody, notifTitle, Topic, Context);`

