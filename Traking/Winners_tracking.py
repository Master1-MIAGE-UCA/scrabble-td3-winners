
from numpy import array
from Winners_tracking import *
import pandas as pd
import numpy as np

class Project:
    global data
    global nomRessources
    nomRessources=[]
    global taches
    taches=[]
    global tacheEffectuees
    tacheEffectuees=[]
    # nomRessources
    def __init__(self, nameProject, duration):
        self.nameProject = nameProject
        self.duration = duration
        print("Projet => Nom: ",nameProject," ;Durée: ",duration)

# RESSOURCES
    def add_resource(self,id,name):
        self.id=id
        self.name=name
        print("Ressources => Nom de la ressource: ",name)
        nomRessources.append(id)

# TASKS
    def add_task(self,id,descr,load=0):
        self.id=id
        self.descr=descr
        self.load=load
        print("Tâches => Id: ",id,"; Workload: ",load,"; Description: ",descr)
        taches.append(id)

    def set_date(self,dateProgress):
        self.dateProgress=dateProgress
        print("\nDate de la progression => ",dateProgress)

    def add_progress(self,task, rsc, work, comment):
        self.task=task 
        self.rsc=rsc
        self.work=work 
        self.comment=comment
        print("Tâche progressée => Id: ",task," Ressource: ",rsc," Workload: ",work," Commentaire: ",comment)
        tacheEffectuees.append([rsc,task,work])

    def print_summary(self):
        taches.append("TotalGeneral");
        nomRessources.append("TotalGeneral");
        data=pd.DataFrame(index = taches, columns = nomRessources)
        for id in data.index:
            for nomResc in data.columns:
                data.loc[id,nomResc]=0
        for nomResc in data.columns:
            for id in data.index:
                for tacheEf in tacheEffectuees:
                    if type(tacheEf[0]) is tuple:  
                        for rescEf in tacheEf[0]:
                            if(nomResc==rescEf and id==tacheEf[1]) :
                                data[nomResc][id]+=tacheEf[2]
                                break
                    else:
                        if(nomResc==tacheEf[0] and id==tacheEf[1]):
                            data[nomResc][id]+=tacheEf[2]
                            

            

        for nomResc in nomRessources:
            data[nomResc]['TotalGeneral']=data[nomResc].sum()
        for i in range(len(data.index)):
            data["TotalGeneral"][data.index[i]]=data.iloc[i].sum()  

        print("\nTableau croisé dynamique:")
        print(data)

print("\nCi-dessous tous les détails du projet:")
prj = Project(nameProject="ScrabbleWinners", duration=46)

# Project resources / team members
print("\nLes membres de l'équipe:")
prj.add_resource(id='DK', name="DIEYE Khadidatou")
prj.add_resource(id='DFB', name="DIALLO Fatoumata B")
prj.add_resource(id='MC', name="MAHDI Chaymae")
prj.add_resource(id='OSF', name="OUAZRI Safouane")
prj.add_resource(id='OSM', name="SAMIA Oussama")
prj.add_resource(id='BL', name="BOUSSADIA Lahcene")
ALL_TEAM = ('DK', 'DFB', 'MC', 'OSM', 'OSF','BL')
NB_TEAM_MEMBERS = len(ALL_TEAM)

# Project tasks
print("\nLes tâches à réaliser:")
prj.add_task(id='IO', descr="Installation des Outils",load=NB_TEAM_MEMBERS * 0.5)
prj.add_task(id='CP', load=10,descr="Création du projet Maven, Intégration Travis, Intégration Java,Création des classes")
prj.add_task(id='MPPM', load=3, descr="Mise en place du projet multimodules: Création des modules avec leur POM et organisation des modules")
prj.add_task(id='IFTT', load=1, descr="Intégration des tests de chaque module sur travis")
prj.add_task(id='EDL1', load=1, descr="Edition Doc Livraison ")
prj.add_task(id='ISB',load=1, descr="Intégration Spring Boot")
prj.add_task(id='APIS',load=2, descr="Création des  différents APIs")
prj.add_task(id='CAPI', load=5, descr="Consommation des APIs")
prj.add_task(id='CG',load=1 ,descr="Création de la grille du scrabble")
prj.add_task(id='CD', load=1,  descr="Créer dictionnaire de mots")
prj.add_task(id='EFT', load=5,descr="Edition fichier de Tracking")
prj.add_task(id='ABS', descr="Abscent ou n'a effectué aucun commit")
prj.add_task(id='M', descr="Malade")
prj.add_task(id='ID',load=1, descr="Intégration Docker")
prj.add_task(id='TU',load=5, descr="Test Unitaire API de APLP")
prj.add_task(id='MPI',load=1, descr="Mise en place des itérations")
prj.add_task(id='PY',load=1, descr="le tracking avec python")
prj.add_task(id='ER', load=5,descr="Edition du rapport finale")

# Project tracking
print("\nLes tâches effectuées:")
# Progression à la date du 09/05/2022
prj.set_date("09/05/2022")
prj.add_progress(task='IO', rsc=ALL_TEAM, work=0.2, comment="Installation des outils")
prj.add_progress(task='CP', rsc="DFB", work=0.8, comment="Intégration du java dans le projet")
prj.add_progress(task='CP', rsc="DK", work=0.8, comment="Mise en place du git ignore")
prj.add_progress(task='CP', rsc="OSM", work=0.8, comment="Création du projet Maven")
prj.add_progress(task='CP', rsc="OSF", work=0.8, comment="Intégration du  travis dans le projet")
prj.add_progress(task='ABS', rsc="MC", work=0.8, comment="N'a effectué aucun commit")
prj.add_progress(task='CP', rsc="BL", work=0.8, comment="Création des classes")

# Progression à la date du 16/05/2022
prj.set_date("16/05/2022")
prj.add_progress(task='EDL1', rsc="DFB", work=1, comment="Création du document livraison à rendre")
prj.add_progress(task='MPPM', rsc="DK", work=1, comment="Mise en place du projet multimodules: Création des modules avec leur POM et organisation des modules")
prj.add_progress(task='CP', rsc="OSM", work=1, comment="Mise à jour du travis")
prj.add_progress(task='CP', rsc="OSF", work=0.5, comment="Mise à jour du travis")
prj.add_progress(task='MPPM', rsc="OSF", work=0.5, comment="Mise en place du projet multimodules: Réorganisation des modules")
prj.add_progress(task='ABS', rsc="MC", work=1, comment="Essaie de push avec Renevier")
prj.add_progress(task='CP', rsc="BL", work=1, comment="Mise à jour du travis")

# Progression à la date du 23/05/2022
prj.set_date("23/05/2022")
prj.add_progress(task='APIS', rsc="DFB", work=0.5, comment="mise en place de l'API permettant de lancer une partie")
prj.add_progress(task='TU', rsc="DFB", work=0.3, comment="Test unitaire de l'API connexion")
prj.add_progress(task='MPI', rsc="DFB", work=0.2, comment="Mise en place des itérations")
prj.add_progress(task='ISB', rsc="DK", work=0.2, comment="Integration finale du sprintboot")
prj.add_progress(task='APIS', rsc="DK", work=0.2, comment="Integration de l'API pour placer un mot")
prj.add_progress(task='APIS', rsc="DK", work=0.4, comment="Mis en place de l'API pour finir une partie")
prj.add_progress(task='ISB', rsc="DK", work=0.2, comment="Integration finale du sprintboot")
prj.add_progress(task='ID', rsc="OSM", work=1, comment="Integration du docker dans le projet")
prj.add_progress(task='MPPM', rsc="OSF", work=1, comment="Ajout de l'identification service dans le module appariement")
prj.add_progress(task='ABS', rsc="MC", work=1, comment="Aucun commit effectué") 
prj.add_progress(task='ABS', rsc="BL", work=1, comment="Aucun commit effectué") 

# Progression à la date du 30/05/2022
prj.set_date("30/05/2022")
prj.add_progress(task='MPPM', rsc="DFB", work=0.4, comment="Ajout de la dépendance de sprintboot dans le module partie")
prj.add_progress(task='CP', rsc="DFB", work=0.2, comment="Mise à jour des itérations")
prj.add_progress(task='EFT', rsc="DFB", work=0.4, comment="Création du traking et mise à jour des traking précédent")
prj.add_progress(task='CP', rsc="DK", work=0.2, comment="Mise à jour des itérations")
prj.add_progress(task='MPPM', rsc="DK", work=0.4, comment="Mise à jour des différent module afin d'intégrer la classe commune")
prj.add_progress(task='EFT', rsc="DK", work=0.4, comment="Création du traking et mise à jour des traking précédent")
prj.add_progress(task='CP', rsc="OSM", work=1, comment="Mise à jour des itérations")
prj.add_progress(task='CP', rsc="OSF", work=1, comment="Mise à jour des itérations")
prj.add_progress(task='CP', rsc="MC", work=1, comment="Mise à jour des itérations")
prj.add_progress(task='M', rsc="BL", work=1, comment="Mise à jour des itérations")


# Progression à la date du 06/06/2022
prj.set_date("06/06/2022")
prj.add_progress(task='CG', rsc="DFB", work=0.8, comment="Création de la grille de scrable")
prj.add_progress(task='EFT', rsc="DFB", work=0.2, comment="Mise à jour de l'historique du traking et création du tableau croisé dynamique")
prj.add_progress(task='EFT', rsc="DK", work=0.2, comment="mise à jour du traking")
prj.add_progress(task='MPPM', rsc="DK", work=0.8, comment="Edition de la classe commune")
prj.add_progress(task='ABS', rsc="OSM", work=1, comment="Aucun commit effectué")
prj.add_progress(task='MPPM', rsc="OSF", work=0.8, comment="Edition du module appariement")
prj.add_progress(task='MPI', rsc="OSF", work=0.2, comment="Edition des itérations")
prj.add_progress(task='ER', rsc="MC", work=1, comment="Edition du rapport")
prj.add_progress(task='ER', rsc="BL", work=1, comment="Edition du rapport")

# Progression à la date du 13/06/2022
prj.set_date("13/06/2022")
prj.add_progress(task='TU', rsc="DFB", work=0.5, comment="Test unitaire de l'API demander un mot")
prj.add_progress(task='EFT', rsc="DFB", work=0.5, comment="mise à jour du traking")
prj.add_progress(task='MPPM', rsc="DK", work=1, comment="Changement des ports de quelques modules")
prj.add_progress(task='ABS', rsc="OSM", work=1, comment="Aucun commit effectué")
prj.add_progress(task='MPPM', rsc="OSF", work=1, comment="Fonctionnement de l'appariement")
prj.add_progress(task='ER', rsc="MC", work=1, comment="Edition du rapport finale")
prj.add_progress(task='ER', rsc="BL", work=1, comment="Edition du rapport finale")

# Progression à la date du 20/06/2022
prj.set_date("20/06/2022")
prj.add_progress(task='EFT', rsc="DFB", work=1, comment="Finalisation du tracking")
prj.add_progress(task='PY', rsc="DK", work=0.5, comment="Création et finalisation du traking ")
prj.add_progress(task='CD', rsc="DK", work=0.5, comment="En cours de création du dictionnaire de données")
prj.add_progress(task='ABS', rsc="OSM", work=1, comment="Aucun commit effectué")
prj.add_progress(task='CAPI', rsc="OSF", work=1, comment="En cours de consommation de tous les API")
prj.add_progress(task='ER', rsc="MC", work=1, comment="Edition du rapport finale")
prj.add_progress(task='ER', rsc="BL", work=1, comment="Edition du rapport finale")

# Print reports
prj.print_summary()