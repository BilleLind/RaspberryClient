# RaspberryClient project
Lavet Sammen med Kelvin
Raspberry server i txt fil med navn raspServe

# Implementeringsstrategi:

Vi vil lave en socket server i python som kan køre på en Raspberry Pi. Serveren vil så indsamle information om temperaturen og luftfugtigheden fra vores Pi. Det vil den så gøre via en DHT11 sensor som er forbundet til Raspberry Pi’en.Vi anvender CircuitPython-DHT biblioteket som er en fortsættelsen af Adafruit_Python_DHT biblioteket, da den blev forældet. Vi vil også lave en klient i java som skal så kunne modtage temperaturdata og luftfugtigheds data. Derefter vil vi så lave en kurve af dataet, hvilket bliver højst sandsynligt via JavaFX eller et andet lignende program. 

# Protokoller:

Dataet fra Raspberry Pi’en bliver sendt med TCP-protokollen, da det er en lille mængde data som bliver sendt i intervaller. Det giver mere mening at bruge TCP end UDP, da TCP bruger three-way-handshake til at sikre dataet er korrekt.

# Konklusion:

Under projektet har vi haft mange problemer som gjorde at vi ikke kunne lave projektet. Det første problem vi stødte ind i mens vi arbejde på opgaven var at vi ikke havde brugt Raspberry Pi før, hvilket viste sig da vi skulle sætte raspberry pi’en op og dets batteri ikke varede længe nok til at vi kunne sætte programmet op. Det næste problem kom så da vi så skulle programmere vores temperaturmåler, da ingen af vores medlemmer havde brugt Python før. Det gjorde at vi brugte ekstra tid på at lære syntaxen til Python så koden rent faktisk virkede. Trods alle problemerne virker programmet og kan sende data til klienten via celsius og luftfugtighed.

