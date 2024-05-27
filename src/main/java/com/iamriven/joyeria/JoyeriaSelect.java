package com.iamriven.joyeria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author usuario
 */
public class JoyeriaSelect {

    public static List<Encantados> recuperarJoyeriaEncantada(String nombre) {
        List<Encantados> listaEncantados = new ArrayList<>();
        EntityManager em = EntityManagerUtil.getEntityManager();

        try {
            TypedQuery<Joyeria> query = em.createQuery(
                    "SELECT j FROM Joyeria j WHERE j.nombre = :nombre", Joyeria.class);
            query.setParameter("nombre", nombre);
            List<Joyeria> joyerias = query.getResultList();

            for (Joyeria joyeria : joyerias) {
                listaEncantados.addAll(joyeria.getEncantadosCollection());
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

        return listaEncantados;
    }

    public static List<Joyeria> recuperarJoyeria() {

        EntityManager em = EntityManagerUtil.getEntityManager();
        List<Joyeria> lista_joyeria = new ArrayList<>();
        try {
            em.getTransaction().begin();

            TypedQuery<Joyeria> query = em.createQuery("SELECT u FROM Joyeria u", Joyeria.class);
            lista_joyeria = query.getResultList();

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

        return lista_joyeria;

    }

    public static void meterJoyeria(String nombre, String tipo) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Joyeria nuevaJoyeria = new Joyeria();
            nuevaJoyeria.setNombre(nombre);
            nuevaJoyeria.setTipo(tipo);

            em.persist(nuevaJoyeria);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

    }

    public static void actualizarJoyeriaSinEncantar(String nombreViejo, String tipoViejo, String nombreNuevo,
            String tipoNuevo) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Query query = em.createQuery(
                    "UPDATE Joyeria j SET j.nombre = :nombreNuevo, j.tipo = :tipoNuevo WHERE j.nombre = :nombreViejo AND j.tipo = :tipoViejo");
            query.setParameter("nombreNuevo", nombreNuevo);
            query.setParameter("tipoNuevo", tipoNuevo);
            query.setParameter("nombreViejo", nombreViejo);
            query.setParameter("tipoViejo", tipoViejo);

            // Ejecutar la actualización
            query.executeUpdate();

            // Confirmar la transacción
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

    }

    public static void addEstadisticas(String nombreJoyeria, int nivel, int ap, int precision, int evasion,
            int precio) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Query countQuery = em.createQuery("SELECT COUNT(e) FROM Encantados e");
            long rowCount = (long) countQuery.getSingleResult();
            int nuevaId = (int) rowCount + 1;

            Query idJoyeriaMain = em.createQuery("SELECT j.idjoyeria FROM Joyeria j WHERE j.nombre = :nombreJoyeria");
            idJoyeriaMain.setParameter("nombreJoyeria", nombreJoyeria);
            int idJoyeria = (int) idJoyeriaMain.getSingleResult();

            Encantados nueva_estadistica = new Encantados();
            nueva_estadistica.getEncantadosPK().setIdNivel(nuevaId);
            nueva_estadistica.getEncantadosPK().setIdjoyeria(idJoyeria);
            nueva_estadistica.setNivel(nivel);
            nueva_estadistica.setPrecio(precio);
            nueva_estadistica.setAp(ap);
            nueva_estadistica.setAccuracy(precision);
            nueva_estadistica.setEvasion(evasion);
            nueva_estadistica.setNombre(nombreJoyeria);
            em.persist(nueva_estadistica);

            // Confirmar la transacción
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }

    }

    public static void actualizarJoyeriaEncantada(String nombreJoyeria, int nivelnuevo, int nivelantiguo, int ap,
            int accuracy, int evasion,
            int precio) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Query query = em.createQuery(
                    "UPDATE Encantados e SET e.ap = :ap, e.accuracy = :accuracy, e.evasion = :evasion, e.precio = :precio, e.nivel = :nivelnuevo WHERE e.nombre = :nombreJoyeria AND e.nivel = :nivelantiguo");
            query.setParameter("ap", ap);
            query.setParameter("accuracy", accuracy);
            query.setParameter("evasion", evasion);
            query.setParameter("precio", precio);
            query.setParameter("nivelnuevo", nivelnuevo);
            query.setParameter("nombreJoyeria", nombreJoyeria);
            query.setParameter("nivelantiguo", nivelantiguo);

            query.executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public static void eliminarStats(String nombreJoyeria, int nivelJoyeria) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Query deleteQuery = em.createQuery(
                    "DELETE FROM Encantados e WHERE e.nombre = :nombreJoyeria AND e.nivel = :nivelJoyeria");
            deleteQuery.setParameter("nombreJoyeria", nombreJoyeria);
            deleteQuery.setParameter("nivelJoyeria", nivelJoyeria);

            deleteQuery.executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public static void eliminarJoyeria(String nombreJoyeria) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Esta elimina todo lo relacionado con la joyería
            Query deleteEncantadosQuery = em.createQuery(
                    "DELETE FROM Encantados e WHERE e.encantadosPK.idjoyeria = " +
                            "(SELECT j.idjoyeria FROM Joyeria j WHERE j.nombre = :nombreVariable)");
            deleteEncantadosQuery.setParameter("nombreVariable", nombreJoyeria);
            int rowsDeletedEncantados = deleteEncantadosQuery.executeUpdate();

            // Luego eliminar la joyería
            Query deleteJoyeriaQuery = em.createQuery(
                    "DELETE FROM Joyeria j WHERE j.nombre = :nombreVariable");
            deleteJoyeriaQuery.setParameter("nombreVariable", nombreJoyeria);
            deleteJoyeriaQuery.executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
}
