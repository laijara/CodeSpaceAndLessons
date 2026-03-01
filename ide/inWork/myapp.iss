; Скрипт Inno Setup для VSCodium Ultimate (с папками compilers, ide, scripts)
; Установка только для текущего пользователя, без прав администратора

#define MyAppName "VSCodium Ultimate"
#define MyAppVersion "1.0"
#define MyAppPublisher "ShamberMicroServices, Inc."
#define MyAppURL "nothing"
; Исполняемый файл лежит в подпапке ide
#define MyAppExeName "codium.exe"   ; или VSCodium.exe – проверьте имя

[Setup]
AppId={{C5AD37ED-96E5-4EE6-A5DC-AAF50EDD4474}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
; Папка установки в профиле пользователя (рекомендуется для per‑user)
DefaultDirName={localappdata}\Programs\{#MyAppName}
UninstallDisplayIcon={app}\ide\{#MyAppExeName}
; Только 64-битные системы
ArchitecturesAllowed=x64compatible
ArchitecturesInstallIn64BitMode=x64compatible
DisableProgramGroupPage=yes
PrivilegesRequired=lowest
OutputBaseFilename=VSCodiumUltimate_Setup
SolidCompression=yes
WizardStyle=modern

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "russian"; MessagesFile: "compiler:Languages\Russian.isl"
; Если нужен русский:
; Name: "russian"; MessagesFile: "compiler:Languages\Russian.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
; Копируем всё содержимое папки vscodium ultimate (compilers, ide, scripts) в корень установки
Source: "D:\gitupload\CodeSpaceAndLessons\ide\inWork\vscodium ultimate\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; Если в этой папке есть другие файлы, которые не нужно копировать (например, сам скрипт .iss),
; лучше переместить их или использовать маску исключений, но пока так.

[Icons]
; Ярлык в меню Пуск – указываем на исполняемый файл внутри папки ide
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\ide\{#MyAppExeName}"; WorkingDir: "{app}"
; Ярлык на рабочем столе (опционально)
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\ide\{#MyAppExeName}"; WorkingDir: "{app}"; Tasks: desktopicon

[Run]
; Запуск после установки
Filename: "{app}\ide\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#MyAppName}}"; Flags: nowait postinstall skipifsilent