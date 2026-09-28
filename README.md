# ChatFilter

Kleines Plugin für Paper- und Spigot-Server, das Wörter im Chat sperrt. Steht ein gesperrtes Wort in einer Nachricht, wird sie nicht normal verschickt.

Gedacht für Minecraft 1.20 (`api-version: 1.20`). Das Repository enthält nur den Quellcode und die Konfigurationsdateien, keine Build-Datei.

## Konfiguration

Alles steht in der `config.yml`:

| Eintrag | Bedeutung |
|---|---|
| `forbidden` | Liste der gesperrten Wörter |
| `show-message` | `true`: Die Nachricht wird angezeigt, das gesperrte Wort durch `*` ersetzt. `false`: Die Nachricht wird verworfen und nur der Spieler bekommt eine Meldung. |
| `rejected-message` | Die Meldung an den Spieler (bei `show-message: false`) |
| `prefix` | Präfix vor dieser Meldung |

Farbcodes schreibt man mit `§`.

## Bekannte Schwächen

- Groß- und Kleinschreibung wird nicht ignoriert, "Asshole" wird also nicht erkannt, wenn nur "asshole" in der Liste steht.
- Es wird nach Textteilen gesucht, ein gesperrtes Wort wird also auch mitten in einem anderen Wort gefunden.
- Stehen mehrere gesperrte Wörter in einer Nachricht, kann sie mehrfach ausgegeben werden.
