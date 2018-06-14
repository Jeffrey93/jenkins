import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("MMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()

pipeline{
	//En el servidor se debe dejar activo el agent con label NodoWindows10Advance, de manera local agent any y el otro comentado
	//agent any
	agent
	{
		label 'NodoWindows10Advance'
	}

	stages{
		stage('Actualizar fuentes Nodo Windows') {
		 	steps{
		 		git url: 'https://github.com/sflorezr/SincronizacionAD.git', credentialsId: 'sflorezr', branch: 'master'
			}
		}

		stage('Test_GUI_Junit'){
				steps{
					script{
						try{
							//sh aplica para servidor y bat para pruebas locales
							sh ("gradle clean test aggregate")
							//bat 'gradle clean test aggregate'
						 	echo 'Ha ejecutado sin fallo hasta test junit'
						}
						catch(ex)
						{    
	    					echo 'Finalizo ejecucion de framework junit con fallos'
	    					error('Failed')
						}
					}
				}
				
			}
			
		stage('BackupEvidencias'){
				steps{
					script{
						try{
							bat "rename ${WORKSPACE}\\target\\site\\serenity serenity_${timestamp}"
						 	echo 'Backup de evidencias realizado con exito'
						}
						catch(ex)
						{    
	    					echo 'Backup de evidencias realizado con fallos'
	    					error('Failed')
						}
					}
				}
			}

		stage('HtmlReport'){
				steps{
					script{
						try{
							publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: "${WORKSPACE}\\target\\site\\serenity_${timestamp}", reportFiles: 'index.html', reportName: 'Identidades Portal', reportTitles: ''])
							echo 'Reporte Html realizado con exito'
						}
						catch(ex)
						{    
	    					echo 'Reporte Html realizado con Fallos'
	    					error('Failed')
						}
					}
				}
			}
		}	
}