from ast import Lambda, Or
from operator import ne
from sysconfig import get_python_version
import pygame
from queue import PriorityQueue

WIDTH = 800
WIN = pygame.display.set_mode((WIDTH, WIDTH))
pygame.display.set_caption("A* Pathfinding Visualizer")