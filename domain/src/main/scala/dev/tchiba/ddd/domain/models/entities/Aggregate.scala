package dev.tchiba.ddd.domain.models.entities

/**
 * 集約の責務を表現する `trait`
 */
trait Aggregate { this: Entity[_] => }
