//npm i multiple-cucumber-html-reporter


const report = require('multiple-cucumber-html-reporter');
var os = require('os');
var ifaces = os.networkInterfaces();
let net =''

Object.keys(ifaces).forEach(function (ifname) {
 var alias = 0;
 ifaces[ifname].forEach(function (iface) {
   if ('IPv4' !== iface.family || iface.internal !== false) {
     // skip over internal (i.e. 127.0.0.1) and non-ipv4 addresses
     return;
   }
   if (alias >= 1) {
     // this single interface has multiple ipv4 addresses
     net= net + (ifname + ':' + alias, iface.address) + ' - ';
   } else {
     // this interface has only one ipv4 adress
     net= net + (ifname, iface.address) + ' - ';
   }
   ++alias;
 });
});

function invocar(){
let jsonDirec, repPath, timeIni, timeFin, nomSO, versSO, titulo

let ip= os.hostname
let user= os.userInfo().username

for (let j = 0; j < process.argv.length; j++) {  
  // console.log(j + ' -> ' + (process.argv[j]));
 if (j==2){  jsonDirec = (process.argv[j])}
 if (j==3) { repPath = (process.argv[j])}
 if (j==4) { timeIni = (process.argv[j])}
 if (j==5) { timeFin = (process.argv[j])}
 if (j==6) { nomSO = (process.argv[j])}
 if (j==8) { verSO = (process.argv[j])}
 if (j==9) { titulo = (process.argv[j])}
console.log(process.argv[j])
}

report.generate({
reportName: titulo,
pageTitle: 'REPORTE CUCUMBER QUIPUX',
pageFooter: 'PIE PAGINA',
displayDuration:true,
durationInMS:true,
   jsonDir: jsonDirec,
   reportPath: repPath,
openReportInBrowser:true,
   metadata:{
app: {
           name: 'DESMONCHES',
           version: '3.0'
       },
       browser: {
           name: 'chrome',
           version: 'Chrome'
       },
       device: ip + ' Usuario: ' + user + ' IP: ' + net ,
       platform: {
           name: nomSO,
           version: verSO
       }
   },
   customData: {
       title: 'Run info',
       data: [
           {label: 'Project', value: 'detran 3.0'},
           {label: 'Release', value: '1.2.3'},
           {label: 'Cycle', value: 'B11221.34321'},
           {label: 'Execution Start Time', value: timeIni},
           {label: 'Execution End Time', value: timeFin}
       ]
   }
})
}
invocar();
