$1_7_R4_CB = "https://cdn.getbukkit.org/craftbukkit/craftbukkit-1.7.10-R0.1-20140808.005431-8.jar"
$1_8_R3_S = "https://cdn.getbukkit.org/spigot/spigot-1.8.8-R0.1-SNAPSHOT-latest.jar"
$1_9_R2_S = "https://cdn.getbukkit.org/spigot/spigot-1.9.4-R0.1-SNAPSHOT-latest.jar"
$1_10_R1_S = "https://cdn.getbukkit.org/spigot/spigot-1.10-R0.1-SNAPSHOT-latest.jar"
$1_11_R1_S = "https://cdn.getbukkit.org/spigot/spigot-1.11.jar"
$1_12_R1_S = "https://cdn.getbukkit.org/spigot/spigot-1.12.jar"
$1_13_R2_S = "https://cdn.getbukkit.org/spigot/spigot-1.13.2.jar"
$1_14_R1_S = "https://cdn.getbukkit.org/spigot/spigot-1.14.4.jar"
$1_15_R1_S = "https://cdn.getbukkit.org/spigot/spigot-1.15.2.jar"
$1_16_R1_S = "https://cdn.getbukkit.org/spigot/spigot-1.16.1.jar"
$1_16_R2_S = "https://cdn.getbukkit.org/spigot/spigot-1.16.3.jar"

New-Item -Path .\dl -ItemType directory

Invoke-WebRequest -Uri $1_7_R4_CB -OutFile ".\dl\1_7_R4_CB.jar"
Invoke-WebRequest -Uri $1_8_R3_S -OutFile ".\dl\1_8_R3_S.jar"
Invoke-WebRequest -Uri $1_9_R2_S -OutFile ".\dl\1_9_R2_S.jar"
Invoke-WebRequest -Uri $1_10_R1_S -OutFile ".\dl\1_10_R1_S.jar"
Invoke-WebRequest -Uri $1_11_R1_S -OutFile ".\dl\1_11_R1_S.jar"
Invoke-WebRequest -Uri $1_12_R1_S -OutFile ".\dl\1_12_R1_S.jar"
Invoke-WebRequest -Uri $1_13_R2_S -OutFile ".\dl\1_13_R2_S.jar"
Invoke-WebRequest -Uri $1_14_R1_S -OutFile ".\dl\1_14_R1_S.jar"
Invoke-WebRequest -Uri $1_15_R1_S -OutFile ".\dl\1_15_R1_S.jar"
Invoke-WebRequest -Uri $1_16_R1_S -OutFile ".\dl\1_16_R1_S.jar"
Invoke-WebRequest -Uri $1_16_R2_S -OutFile ".\dl\1_16_R2_S.jar"

& mvn install:install-file -D"file=.\dl\1_7_R4_CB.jar" -D"version=1.7.10-R0.1-SNAPSHOT" -D"groupId=org.bukkit" -D"artifactId=craftbukkit" -D"packaging=jar"

& mvn install:install-file -D"file=.\dl\1_8_R3_S.jar" -D"version=1.8.8-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_9_R2_S.jar" -D"version=1.9.4-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_10_R1_S.jar" -D"version=1.10-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_11_R1_S.jar" -D"version=1.11-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_12_R1_S.jar" -D"version=1.12-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_13_R2_S.jar" -D"version=1.13.2-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_14_R1_S.jar" -D"version=1.14.4-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_15_R1_S.jar" -D"version=1.15.2-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_16_R1_S.jar" -D"version=1.16.1-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"
& mvn install:install-file -D"file=.\dl\1_16_R2_S.jar" -D"version=1.16.3-R0.1-SNAPSHOT" -D"groupId=org.spigotmc" -D"artifactId=spigot" -D"packaging=jar"

#Remove-Item '.\dl' -Recurse
