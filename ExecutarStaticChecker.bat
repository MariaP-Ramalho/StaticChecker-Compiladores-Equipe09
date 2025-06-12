@echo off
set /p nomeBase=Digite o nome base do arquivo (sem .251): 
echo.
if exist %nomeBase%.251 (
    java -jar StaticChecker.jar %nomeBase%
    echo.
    echo Análise concluída. Arquivos %nomeBase%.LEX e %nomeBase%.TAB gerados.
) else (
    echo.
    echo Arquivo %nomeBase%.251 não encontrado.
)
pause
