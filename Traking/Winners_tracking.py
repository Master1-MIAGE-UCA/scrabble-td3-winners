
from Winners_tracking import *
class Project:
    def __init__(self, name, duration):
         self.name = name
         self.duration = duration
# RESSOURCES
    def add_resource(self,id,name):
        self.id=id
        self.name=name
# TASKS
    def add_task(self,id,descr,load,resp):
        self.id=id
        self.descr=descr
        self.load=load
        self.resp=resp

    def set_date(self,date):
        self.date=date
    def add_progress(self,task, rsc, work, comment):
        self.task=task 
        self.rsc=rsc
        self.work=work 
        self.comment=comment

    def print_summary(self,test):
        self.test=test

prj = Project(name="ScrabbleWinners", duration=12)
# Project resources / team members
prj.add_resource(id='KD', name="DIEYE Khadidatou")
prj.add_resource(id='FD', name="DIALLO Fatoumata B")
prj.add_resource(id='CM', name="MAHDI Chaymae")
prj.add_resource(id='SO', name="OUAZRI Safouane")
prj.add_resource(id='OS', name="SAMIA Oussama")
prj.add_resource(id='LB', name="BOUSSADIA Lahcene")
ALL_TEAM = ('KD', 'FD', 'CM', 'OS', 'SO','LB')
NB_TEAM_MEMBERS = len(ALL_TEAM)
# Project tasks
prj.add_task(id='IO', descr="Installation des Outils")
prj.add_task(id='CP', load=NB_TEAM_MEMBERS * 0.8, descr="Création du projet Maven, Intégration Travis, Intégration Java,Création des classes")
prj.add_task(id='MPPM', load=NB_TEAM_MEMBERS * 1.6, descr="Mise en place du projet multimodules: Création des modules avec leur POM et organisation des modules")
prj.add_task(id='IFTT', load=NB_TEAM_MEMBERS * 0.4, descr="Intégration des tests de chaque module sur travis")
prj.add_task(id='EDL', load=NB_TEAM_MEMBERS * 1.0, descr="Edition Doc Livraison ")
prj.add_task(id='ISB', descr="Intégration Spring Boot")
prj.add_task(id='APIS', descr="Création des  différents APIs")
prj.add_task(id='CAPI', load=2, resp='P1', descr="Consommation des APIs")
prj.add_task(id='CG', descr="Création de la grille du scrabble")
prj.add_task(id='CD', load=3, resp='P2', descr="Créer dictionnaire de mots")
prj.add_task(id='EFT', descr="Edition fichier de Tracking")
prj.add_task(id='ABS', descr="Abscent ou n'a effectué aucun commit")
prj.add_task(id='M', descr="Malade")
prj.add_task(id='ID', descr="Intégration Docker")
prj.add_task(id='TU', descr="Test Unitaire API de APLP")
prj.add_task(id='MPI', descr="Mise en place des itérations")
prj.add_task(id='ER', descr="Edition du rapport finale")
# Project tracking
prj.set_date("23/05/2022")
prj.add_progress(task='IO', rsc=ALL_TEAM, work=0.2, comment="Istallation des outils")
prj.add_progress(task='CP', rsc=ALL_TEAM, work=0.2, comment="Création du projet Maven, Intégration Travis, Intégration Java,Création des classes")
prj.add_progress(task='MPPM', rsc=ALL_TEAM, work=0.2, comment="Mise en place du projet multimodules: Création des modules avec leur POM et organisation des modules")
prj.add_progress(task='MPPM', rsc=ALL_TEAM, work=0.2, comment="Mise en place du projet multimodules: Création des modules avec leur POM et organisation des modules")
prj.add_progress(task='ISB', rsc=ALL_TEAM, work=0.2, comment="Intégration Spring Boot")
prj.add_progress(task='APIS', rsc=ALL_TEAM, work=0.2, comment="Création des  différents APIs")

prj.set_date("30/05/2022")
prj.add_progress(task='APIS', rsc=ALL_TEAM, work=0.2, comment="Création des  différents APIs")
prj.add_progress(task='ID', rsc=ALL_TEAM, work=0.2, comment="Intégration Docker")
prj.add_progress(task='MPI', rsc=ALL_TEAM, work=0.2, comment="Mise en place des itérations")
prj.add_progress(task='CAPI', rsc=ALL_TEAM, work=0.2, comment="Consommation des APIs")


# Print reports
prj.print_summary()